package sg.edu.np.mad.madpractical;


import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AA_RecyclerViewAdapter extends RecyclerView.Adapter<AA_RecyclerViewAdapter.MyViewHolder> {

    private final RecyclerViewInterface recyclerViewInterface;
    Context context;
    ArrayList<UserModel> userModels;

    public AA_RecyclerViewAdapter(Context context,ArrayList<UserModel> userModels,RecyclerViewInterface recyclerViewInterface)
    {
        this.context=context;
        this.userModels=userModels;
        this.recyclerViewInterface=recyclerViewInterface;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view =inflater.inflate(R.layout.recycler_view_row,parent,false);
        return new MyViewHolder(view, recyclerViewInterface);
    }

    @Override
    public void onBindViewHolder(@NonNull AA_RecyclerViewAdapter.MyViewHolder holder, int position) {
            holder.textView.setText(userModels.get(position).getMsg());
            holder.textView1.setText(userModels.get(position).getDesc());

    }

    @Override
    public int getItemCount() {
        return userModels.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        ImageView imageView ;
        TextView textView,textView1;
         public MyViewHolder(@NonNull View itemView,RecyclerViewInterface recyclerViewInterface) {
            super(itemView);
            imageView=itemView.findViewById(R.id.imageView);
            textView=itemView.findViewById(R.id.textView4);
            textView1=itemView.findViewById(R.id.textView2);

             imageView.setOnClickListener(new View.OnClickListener() {
                 @Override
                 public void onClick(View v) {
                     if (recyclerViewInterface != null){
                         int pos=getAdapterPosition();
                         if (pos !=RecyclerView.NO_POSITION){
                             recyclerViewInterface.onItemClick(pos);
                         }

                     }

                 }
             });
        }
    }
}
