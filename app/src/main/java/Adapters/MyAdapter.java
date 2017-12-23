package Adapters;

import android.app.LauncherActivity;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.vaibhav.recyclerapp.DetailsActivity;
import com.example.vaibhav.recyclerapp.R;

import java.util.List;

import Model.ListItem;

/**
 * Created by vaibhav on 22-12-2017.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private Context context;
    private List<ListItem> listitems;


    public MyAdapter(Context context, List listitem){
            this.context=context;
           this.listitems=listitem;

    }
    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_row,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyAdapter.ViewHolder holder, int position) {
        ListItem item = listitems.get(position);
        holder.name.setText(item.getName());
        holder.description.setText(item.getDescription());

    }

    @Override
    public int getItemCount() {
        return listitems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public TextView name;
        public TextView description;
        public ViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);

            name=(TextView)itemView.findViewById(R.id.title);
            description=(TextView)itemView.findViewById(R.id.description);

        }

        @Override
        public void onClick(View v) {
            int positon=getAdapterPosition();
            ListItem item= listitems.get(positon);
            Intent i= new Intent(context, DetailsActivity.class);
            i.putExtra("name",item.getName());
            i.putExtra("description",item.getDescription());
            context.startActivity(i);

            Toast.makeText(context,item.getName(),Toast.LENGTH_LONG).show();

        }
    }
}
