package com.example.movieguide.helper;

import io.reactivex.disposables.Disposable;

/**
 * @author Irfan Andriansyah
 */
public class RxUtils
{
    public static void unsubscribe(Disposable subscription)
    {
        if (subscription != null && !subscription.isDisposed())
        {
            subscription.dispose();
        }
    }

    public static void unsubscribe(Disposable... subscriptions)
    {
        for (Disposable subscription : subscriptions)
        {
            unsubscribe(subscription);
        }
    }
}
