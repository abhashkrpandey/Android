package com.example.myapplication.viewModel

import androidx.lifecycle.ViewModel
import com.example.myapplication.model.UserProfile
import com.example.myapplication.repositry.Repositry
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class SignupLoginViewModel() : ViewModel() {

    private var userProfileViewModelState =
        MutableStateFlow(UserProfile()) // can be changed that why private
    var accessibleUserProfileViewModelState =
        userProfileViewModelState.asStateFlow();  // can only be read that why public

    fun createUser(name: String, mobileNo: String, password: String,appRepo: Repositry): Boolean {
        userProfileViewModelState.value = UserProfile(name, mobileNo, password)
        return appRepo.add(name, mobileNo, password)
    }

    fun verifyUser(name: String, mobileNo: String, password: String,appRepo: Repositry): Boolean {
        var userData = appRepo.getter();
        var savedName = userData.get(0);
        var savedMobile = userData.get(1);
        var savedPassword = userData.get(2);
        if (savedName == name && savedMobile == mobileNo && savedPassword == password)
            return true;
        else
            return false;
    }

    fun getUserInfo(appRepo: Repositry): ArrayList<String> {
        return appRepo.getter();
    }
}