package com.utoo.werent.ui.base;

/**
 * Created by Lenovo on 2015/8/24.
 */
public interface BaseView {
    public void showDialog(String title, String message,
                           final DialogWorkCallback callback);


    public void showProgressDialog(String title);

    public void closeProgressDialog();

    public interface DialogWorkCallback {
        public void SubmitClick();

        public void QuitClick();
    }

    public void toastMessage(String msg);
}
