package com.rais.haidar.themeal.Base;

public interface BasePresenter<T extends BaseView> {
    void onAttach(T v);
    void onDetach();

}
