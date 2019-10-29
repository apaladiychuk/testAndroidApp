package ua.itap.testapp;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import java.util.HashMap;
import java.util.Map;

import ua.itap.testapp.screens.main.MainViewModel;

public class ViewModelFactory  implements ViewModelProvider.Factory{
    static  Map<String, ViewModel> hashMapViewModel = new HashMap();

    public static void addViewModel(String key, ViewModel  viewModel){
        hashMapViewModel.put(key, viewModel) ;
    }

    public static ViewModel getViewModel(String key) {
        return hashMapViewModel.get(key);
    }
    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        MainViewModel  vm = (MainViewModel) hashMapViewModel.get("mainView");
        if ( vm != null ){
            return (T)vm ;
        } else {
            vm = new MainViewModel();
            hashMapViewModel.put("mainView", vm);
            return (T)vm ;
        }

    }
}
