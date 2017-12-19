package com.neetogami.criptoapp.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.neetogami.criptoapp.Fragments.CursosFragment;
import com.neetogami.criptoapp.Interfaces.WebServicesAWS;
import com.neetogami.criptoapp.Models.CompraUser;
import com.neetogami.criptoapp.Models.Curso;
import com.neetogami.criptoapp.R;
import com.squareup.picasso.Picasso;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * Created by segun on 19/12/2017.
 */

public class CursosAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private List<Curso> cursos;
    private List<CompraUser> comprasUser;
    private CursosFragment cursosFragment;
    private String user;
    private Retrofit retrofit;
    private WebServicesAWS webService;

    public CursosAdapter(Context context, int layout, List<Curso> cursos, List<CompraUser> compras, CursosFragment cursosFragment,String user) {
        this.context = context;
        this.layout = layout;
        this.cursos = cursos;
        this.comprasUser = compras;
        this.cursosFragment = cursosFragment;
        this.user = user;
        retrofit= new Retrofit.Builder()
                .baseUrl("https://jw67nf8i8h.execute-api.us-east-1.amazonaws.com/prod/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        webService = retrofit.create(WebServicesAWS.class);
    }

    @Override
    public int getCount() {
        return cursos.size();
    }

    @Override
    public Curso getItem(int position) {
        return cursos.get(position);
    }

    @Override
    public long getItemId(int id) {
        return id;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        final CursosAdapter.ViewHolder holder;

        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(layout, null);
            holder = new CursosAdapter.ViewHolder();
            holder.name = (TextView) convertView.findViewById(R.id.textViewCursoNombre);
            holder.profesor = (TextView) convertView.findViewById(R.id.textViewCursoProfesor);
            holder.precio = (TextView) convertView.findViewById(R.id.textViewCursoPrecio);
            holder.btnBuy = (Button) convertView.findViewById(R.id.btnBuy);
            holder.image = (ImageView) convertView.findViewById(R.id.imageViewFlag);
            convertView.setTag(holder);
        } else {
            holder = (CursosAdapter.ViewHolder) convertView.getTag();
        }

        final Curso currentCurso = getItem(position);
        holder.name.setText(currentCurso.getNombreCurso());
        holder.profesor.setText("Prof. " + currentCurso.getProfesorCurso());
        holder.precio.setText("$"+currentCurso.getPrecioInscripcion());
        if(isBuyed(currentCurso.getCursoId()))
            holder.btnBuy.setEnabled(false);
        else {
            holder.btnBuy.setEnabled(true);
            holder.btnBuy.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    CompraUser newCompra = new CompraUser(user+"_"+currentCurso.getCursoId(),currentCurso.getCursoId(),
                            currentCurso.getNombreCurso(), getFechaActual(),currentCurso.getPrecioInscripcion(),user);
                    comprasUser.add(newCompra);
                    currentCurso.setAlumnosInscritos(currentCurso.getAlumnosInscritos()+1);
                    updateCurso(currentCurso);
                    cursosFragment.comprarCurso(newCompra);
                }
            });
        }
        String url = currentCurso.getFlagURL();
        Picasso.with(context).load(url).into(holder.image);
        return convertView;
    }
    private boolean isBuyed(String keyCurso){
        for(CompraUser c : comprasUser){
            if(c.getCursoId().compareToIgnoreCase(keyCurso)==0)
                return true;
        }
        return false;
    }
    public void  updateCurso(Curso curso){
        //Testing metodo POST con retrofit
        Call<String> comprasUserCallPost = webService.setCurso(curso);
        comprasUserCallPost.enqueue(new Callback<String>(){
            public void onFailure(Call<String> call, Throwable t) {
                // TODO Auto-generated method stub
                System.out.println("error al consumir la api" + t );
            }
            public void onResponse(Call<String> call, Response<String> response) {
                String resp = response.body();
                if(resp.compareTo("200")==0)
                    System.out.println("Insert Curso Correct!!!");
                else
                    System.out.println("Error Insert!!!");
                // TODO Auto-generated method stub
            }
        });
    }

    public static String getFechaActual() {
        Date ahora = new Date();
        SimpleDateFormat formateador = new SimpleDateFormat("dd/MM/yyyy");
        return formateador.format(ahora);
    }

    static class ViewHolder {
        private TextView name;
        private TextView profesor;
        private TextView precio;
        private ImageView image;
        private Button btnBuy;
    }
}
