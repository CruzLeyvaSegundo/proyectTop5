package com.neetogami.criptoapp.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.neetogami.criptoapp.Models.CompraUser;
import com.neetogami.criptoapp.R;
import com.squareup.picasso.Picasso;
import java.util.List;

/**
 * Created by segun on 19/12/2017.
 */

public class ComprasAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private List<CompraUser> compras;

    public ComprasAdapter(Context context, int layout, List<CompraUser> compras) {
        this.context = context;
        this.layout = layout;
        this.compras = compras;
    }

    @Override
    public int getCount() {
        return compras.size();
    }

    @Override
    public CompraUser getItem(int position) {
        return compras.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ComprasAdapter.ViewHolder holder;

        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(layout, null);
            holder = new ComprasAdapter.ViewHolder();
            holder.name = (TextView) convertView.findViewById(R.id.textViewCompraName);
            holder.fecha = (TextView) convertView.findViewById(R.id.textViewCompraFecha);
            holder.precio = (TextView) convertView.findViewById(R.id.textViewCompraPrecio);
            holder.image = (ImageView) convertView.findViewById(R.id.imageViewCardCredit);
            convertView.setTag(holder);
        } else {
            holder = (ComprasAdapter.ViewHolder) convertView.getTag();
        }

        CompraUser currentCompra = getItem(position);

        holder.name.setText(currentCompra.getNombreCurso());
        holder.fecha.setText("Date: " + currentCompra.getFechaCompra());
        holder.precio.setText("$"+currentCompra.getPrecioCompra());

        String url = "https://www.carrefour.es/e-commerce/www/documentos/pass/20151119/img/icons-pass/icon-tarjeta-home-blue.png";
        Picasso.with(context).load(url).into(holder.image);
        return convertView;
    }

    static class ViewHolder {
        private TextView name;
        private TextView fecha;
        private TextView precio;
        private ImageView image;
    }
}
