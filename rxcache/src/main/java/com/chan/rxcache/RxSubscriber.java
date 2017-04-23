package com.chan.rxcache;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * 作者： fangguiliang  时间： 16/8/24.
 * 功能：订阅处理结果,可以不局限于网络,但{@link #onError(Throwable)}仅处理了网络出错的情况
 * 修改：
 */

public abstract class RxSubscriber<T> implements Observer<T> {
    private boolean isShowToast = true;
    public Disposable mDisposable;

    protected RxSubscriber() {
    }

    public RxSubscriber(boolean isShowToast) {
        this.isShowToast = isShowToast;
    }


    @Override
    public void onComplete() {

    }

    @Override
    public void onSubscribe(Disposable d) {
        mDisposable = d;
    }

    public void dispose() {
        mDisposable.dispose();
    }

    @Override
    public void onError(Throwable e) {
        e.printStackTrace();
        onFail(e);
    }

    @Override
    public void onNext(T data) {
        onSuccess(data);
    }

    public abstract void onSuccess(T data);

    public void onFail(Throwable e) {

    }

}