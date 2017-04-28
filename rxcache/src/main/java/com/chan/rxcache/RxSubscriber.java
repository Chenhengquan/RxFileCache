package com.chan.rxcache;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Author : ChenHengQuan
 * Time : 2017/4/28.
 * Email : nullpointerchan@163.com
 * Desc :
 * version : v1.0
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