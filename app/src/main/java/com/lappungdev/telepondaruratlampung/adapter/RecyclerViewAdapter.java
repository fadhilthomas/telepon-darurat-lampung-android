package com.lappungdev.telepondaruratlampung.adapter;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import com.lappungdev.telepondaruratlampung.R;
import com.lappungdev.telepondaruratlampung.model.Telepon;

import java.util.ArrayList;
import java.util.List;


public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> implements Filterable {

    private Context context;
    private List<Telepon> teleponList, telepontempList;
    private String telp = "Telp: ";
    private ValueFilter valueFilter;

    public RecyclerViewAdapter(Context context, List<Telepon> TempList) {
        this.teleponList = TempList;
        this.telepontempList = TempList;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_items, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        Telepon teleponInfo = teleponList.get(position);
        holder.tvNama.setText(teleponInfo.getNama());
        holder.tvTelepon.setText(telp + teleponInfo.getTelepon());
    }

    @Override
    public int getItemCount() {
        return teleponList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvNama, tvTelepon;
        CardView cvTask;

        ViewHolder(final View itemView) {
            super(itemView);

            tvNama = itemView.findViewById(R.id.tvNama);
            tvTelepon = itemView.findViewById(R.id.tvTelepon);
            cvTask = itemView.findViewById(R.id.cvTask);

            itemView.setOnClickListener(new View.OnClickListener(){

                @Override
                public void onClick(View v) {
                    final Dialog alertDialog = new Dialog(itemView.getContext());
                    alertDialog.setContentView(R.layout.result);
                    Button btSalin = alertDialog.findViewById(R.id.btSalin);
                    Button btPanggil = alertDialog.findViewById(R.id.btPanggil);

                    btSalin.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent sendIntent = new Intent();
                            sendIntent.setAction(Intent.ACTION_SEND);
                            sendIntent.putExtra(Intent.EXTRA_TEXT, teleponList.get(getAdapterPosition()).getNama() + ": "+ teleponList.get(getAdapterPosition()).getTelepon());
                            sendIntent.setType("text/plain");
                            sendIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            itemView.getContext().startActivity(Intent.createChooser(sendIntent, "Kirim"));
                            alertDialog.dismiss();
                        }
                    });

                    btPanggil.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent callIntent = new Intent(Intent.ACTION_CALL);
                            callIntent.setData(Uri.parse("tel:"+teleponList.get(getAdapterPosition()).getTelepon()));
                            if (ActivityCompat.checkSelfPermission(context, android.Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                                return;
                            }
                            callIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            context.startActivity(callIntent);
                            alertDialog.dismiss();
                        }
                    });
                    alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                    alertDialog.show();
                }
            });
        }
    }

    @Override
    public Filter getFilter() {
        teleponList = telepontempList;
        if (valueFilter == null) {
            valueFilter = new ValueFilter();
        }
        return valueFilter;
    }

    private class ValueFilter extends Filter {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            FilterResults results = new FilterResults();

            if (constraint != null && constraint.length() > 0) {
                ArrayList<Telepon> filterList = new ArrayList<>();
                for (int i = 0; i < teleponList.size(); i++) {
                    if ((teleponList.get(i).getNama().toUpperCase()).contains(constraint.toString().toUpperCase())) {
                        Telepon telepon = new Telepon(teleponList.get(i).getNama(), teleponList.get(i).getTelepon());
                        filterList.add(telepon);
                    }
                }
                results.count = filterList.size();
                results.values = filterList;
            } else {
                results.count = teleponList.size();
                results.values = teleponList;
            }
            return results;

        }

        @Override
        protected void publishResults(CharSequence constraint,
                                      FilterResults results) {
            teleponList = (ArrayList<Telepon>) results.values;
            notifyDataSetChanged();
        }

    }
}
