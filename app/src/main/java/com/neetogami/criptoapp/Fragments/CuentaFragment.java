package com.neetogami.criptoapp.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import com.neetogami.criptoapp.Adapters.ComprasAdapter;
import com.neetogami.criptoapp.Interfaces.WebServicesAWS;
import com.neetogami.criptoapp.Models.CompraUser;
import com.neetogami.criptoapp.Models.Curso;
import com.neetogami.criptoapp.R;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * A simple {@link Fragment} subclass.
 */
public class CuentaFragment extends Fragment {
    private ListView listView;
    private ComprasAdapter adapter;
    private String user;
    private Retrofit retrofit;
    private WebServicesAWS webService;
    private List<CompraUser> listCompras;

    public CuentaFragment() {
        retrofit= new Retrofit.Builder()
                .baseUrl("https://jw67nf8i8h.execute-api.us-east-1.amazonaws.com/prod/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        webService = retrofit.create(WebServicesAWS.class);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cuenta, container, false);

        getComprasUser(view);
        return view;
    }

    public void sendUser(String user) {
        this.user = user;
        System.out.println("Username: "+ user + " en fragment CUENTA");
    }
    public void  getComprasUser(final View view){
        //Testing metodo POST con retrofit
        Call<List<CompraUser>> comprasUserCallPost = webService.getComprasUser(user);
        comprasUserCallPost.enqueue(new Callback<List<CompraUser>>(){
            public void onFailure(Call<List<CompraUser>> call, Throwable t) {
                // TODO Auto-generated method stub
                System.out.println("error al consumir la api" + t );
            }
            public void onResponse(Call<List<CompraUser>> call, Response<List<CompraUser>> response) {
                // TODO Auto-generated method stub
                listCompras = response.body();
                listView = (ListView) view.findViewById(R.id.listViewCompras);
                adapter = new ComprasAdapter(getContext(),R.layout.list_view_item_compra,listCompras);
                listView.setAdapter(adapter);
                System.out.println("Testing completo");
            }
        });
    }

    public void addCompra(CompraUser newCompra) {
        this.listCompras.add(newCompra);
        adapter.notifyDataSetChanged();
    }

}
