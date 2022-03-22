package sn.maliki.projetvente;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class EleveAdapter extends BaseAdapter {
    private List<Eleve> eleves;
    private Context ctx;

    public EleveAdapter(List<Eleve> eleves, Context ctx) {
        this.eleves = eleves;
        this.ctx = ctx;
    }

    public void setEleves(List<Eleve> eleves) {
        if (eleves==null){
            this.eleves = new ArrayList<>();
        }else {
            this.eleves = eleves;
        }
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return eleves.size();
    }

    @Override
    public Object getItem(int position) {
        return eleves.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView==null){
            convertView = LayoutInflater.from(ctx).inflate(R.layout.eleve_item, parent, false);
        }
        TextView prenomLabel = convertView.findViewById(R.id.prenomLabel);
        TextView nomLabel = convertView.findViewById(R.id.nomLabel);
        TextView prenom = convertView.findViewById(R.id.prenomValue);
        TextView nom = convertView.findViewById(R.id.nomValue);

        Eleve e = (Eleve) getItem(position);

        prenom.setText(e.getPrenom());
        nom.setText(e.getNom());

        if (position % 2 == 0){
            convertView.setBackgroundColor(ctx.getColor(R.color.purple_700));
            prenom.setTextColor(ctx.getColor(R.color.white));
            nom.setTextColor(ctx.getColor(R.color.white));
            prenomLabel.setTextColor(ctx.getColor(R.color.white));
            nomLabel.setTextColor(ctx.getColor(R.color.white));
        }else{
            convertView.setBackgroundColor(ctx.getColor(R.color.white));
            prenom.setTextColor(ctx.getColor(R.color.purple_700));
            nom.setTextColor(ctx.getColor(R.color.purple_700));
            prenomLabel.setTextColor(ctx.getColor(R.color.purple_700));
            nomLabel.setTextColor(ctx.getColor(R.color.purple_700));
        }
        return convertView;
    }
}
