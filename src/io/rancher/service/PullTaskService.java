package io.rancher.service;

import io.rancher.base.Filters;
import io.rancher.base.TypeCollection;
import io.rancher.type.PullTask;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.QueryMap;

public interface PullTaskService {

  @GET("pullTask")
  Call<TypeCollection<PullTask>> list();

  @GET("pullTask")
  Call<TypeCollection<PullTask>> list(@QueryMap Filters filters);

  @GET("pullTask/{id}")
  Call<PullTask> get(@Path("id") String id);

  @POST("pullTask")
  Call<PullTask> create(@Body PullTask pullTask);

  @PUT("pullTask/{id}")
  Call<PullTask> update(@Path("id") String id, @Body PullTask pullTask);

  @DELETE("pullTask/{id}")
  Call<Response> delete(@Path("id") String id);
  
}
