package com.neetogami.criptoapp.Interfaces;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

import com.neetogami.criptoapp.Models.CompraUser;
import com.neetogami.criptoapp.Models.Curso;
import com.neetogami.criptoapp.Models.User;

import java.util.List;


/**
 * Created by segun on 18/12/2017.
 */

public interface WebServicesAWS {
    //GET METHODS  -- Todos los metodos GET han sido testeados
    @GET("userinfo")
    Call<List<User>> getUsers();

    @GET("userinfo/{userId}")
    Call<User> getUser(@Path("userId") String userId);

    @GET("cursoinfo")
    Call<List<Curso>> getCursos();

    @GET("cursoinfo/{cursoId}")
    Call<Curso> getCurso(@Path("cursoId") String cursoId);

    @GET("comprasCurso")
    Call<List<CompraUser>> getComprasUsers();

    @GET("comprasCurso/{compraId}")
    Call<CompraUser> getCompraCurso(@Path("compraId") String compraId);

    @GET("comprasCurso/comprasUser/{userId}")
    Call<List<CompraUser>> getComprasUser(@Path("userId") String userId);

    //POST METHODS  ---- Todos los metodos POST han sido testeados

    @POST("userinfo")
    Call<String> setUser(@Body User request);

    @POST("cursoinfo")
    Call<String> setCurso(@Body Curso request);

    @POST("comprasCurso")
    Call<String> setCompraUser(@Body CompraUser request);

}
