package com.neetogami.criptoapp.Fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import com.neetogami.criptoapp.Adapters.CursosAdapter;
import com.neetogami.criptoapp.Interfaces.OnCursoBuyed;
import com.neetogami.criptoapp.Interfaces.WebServicesAWS;
import com.neetogami.criptoapp.Models.CompraUser;
import com.neetogami.criptoapp.Models.Curso;
import com.neetogami.criptoapp.R;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * A simple {@link Fragment} subclass.
 */
public class CursosFragment extends Fragment{
    private OnCursoBuyed onCursoBuyed;
    private ListView listView;
    private CursosAdapter adapter;
    private Retrofit retrofit;
    private WebServicesAWS webService;
    private String user;
    private List<Curso> cursos;
    private List<CompraUser> compraUsers;

    public CursosFragment() {
        retrofit= new Retrofit.Builder()
                .baseUrl("https://jw67nf8i8h.execute-api.us-east-1.amazonaws.com/prod/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        webService = retrofit.create(WebServicesAWS.class);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cursos, container, false);
        //Data
        getCursos(view,this);
        return view;
    }
    public void sendUser(String user) {
        this.user = user;
        System.out.println("Username: "+ user + " en fragment CURSOS");
    }

    public void  getCursos(final View view,final CursosFragment cursosFragment){
        //Testing metodo POST con retrofit
        Call<List<Curso>> comprasUserCallPost = webService.getCursos();
        comprasUserCallPost.enqueue(new Callback<List<Curso>>(){
            public void onFailure(Call<List<Curso>> call, Throwable t) {
                // TODO Auto-generated method stub
                System.out.println("error al consumir la api" + t );
            }
            public void onResponse(Call<List<Curso>> call, Response<List<Curso>> response) {
                // TODO Auto-generated method stub
                cursos = response.body();
                Call<List<CompraUser>> comprasUserCallPost = webService.getComprasUser(user);
                comprasUserCallPost.enqueue(new Callback<List<CompraUser>>(){
                    public void onFailure(Call<List<CompraUser>> call, Throwable t) {
                        // TODO Auto-generated method stub
                        System.out.println("error al consumir la api" + t );
                    }
                    public void onResponse(Call<List<CompraUser>> call, Response<List<CompraUser>> response) {
                        // TODO Auto-generated method stub
                        compraUsers = response.body();
                        listView = (ListView) view.findViewById(R.id.listViewCursos);
                        adapter = new CursosAdapter(getContext(),R.layout.list_view_item_curso,cursos,compraUsers,cursosFragment,user);
                        listView.setAdapter(adapter);
                        System.out.println("Testing completo");
                    }
                });
            }
        });
    }
    public void comprarCurso(CompraUser newCompra){
        //Toast.makeText(getContext(),"Hola",Toast.LENGTH_SHORT).show();
        setCompraUser(newCompra);
        onCursoBuyed.buyCurso(newCompra);
        adapter.notifyDataSetChanged();
        System.out.println("Holaaa Compro un curso: "+ newCompra.getNombreCurso());
    }

    public void  setCompraUser(CompraUser newCompra){
        //Testing metodo POST con retrofit
        Call<String> comprasUserCallPost = webService.setCompraUser(newCompra);
        comprasUserCallPost.enqueue(new Callback<String>(){
            public void onFailure(Call<String> call, Throwable t) {
                // TODO Auto-generated method stub
                System.out.println("error al consumir la api" + t );
            }
            public void onResponse(Call<String> call, Response<String> response) {
                String resp = response.body();
                if(resp.compareTo("200")==0)
                    System.out.println("Insert newCompra Correct!!!");
                else
                    System.out.println("Error Insert!!!");
                // TODO Auto-generated method stub
            }
        });
    }
    // Eventos para enlazar el listener
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnCursoBuyed) {
            onCursoBuyed = (OnCursoBuyed) context;
        } else {
            throw new RuntimeException(context.toString() + " must implement OnPersonCreated");
        }
    }
    // Eventos para desenlazar el listener
    @Override
    public void onDetach() {
        super.onDetach();
        onCursoBuyed = null;
    }

}
