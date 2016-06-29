package jacksen.sqlitedemo.utils;

import android.os.Handler;
import android.os.Looper;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Admin on 2016/6/28.
 */
public abstract class DbCommand<T> {

    // 单一线程的线程池，用作数据库执行引擎
    private static ExecutorService dbEngine = Executors.newSingleThreadExecutor();

    // 主线程消息队列的handler
    private static final Handler mainHandler = new Handler(Looper.getMainLooper());

    // 执行数据库操作
    public final void execute(){
        dbEngine.execute(new Runnable() {
            @Override
            public void run() {
                try{
                    postResult(doInBackground());
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });
    }

    // 将结果传递给UI线程
    private void postResult(final T result){
        mainHandler.post(new Runnable() {
            @Override
            public void run() {
                onPostExecute(result);
            }
        });
    }

    //
    protected abstract T doInBackground();

    //
    protected void onPostExecute(T result){

    }

}
