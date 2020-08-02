package com.example.new2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class gymadapter extends RecyclerView.Adapter<gymadapter.MyViewHolder> {

    private ArrayList<String> gymname = new ArrayList<>();
    private ArrayList<String> images = new ArrayList<>();
    private ArrayList<String> description = new ArrayList<>();
    private Context mcontext;
    private ArrayList<datagym> mlist;
    //private List<ClipData.Item> mDataset;

    // Provide a suitable constructor (depends on the kind of dataset)
    public gymadapter(Context context, ArrayList<datagym> list) {          //  Arraylist<String> dectemp,ArrayList<String> gymnametemp,ArrayList<String> imagetemp
        //gymname =gymnametemp;
        //images=imagetemp;
        //description=dectemp;
        mlist=list;
        mcontext=context;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public gymadapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.gymitem,parent,false);
        return new MyViewHolder(view);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {

        datagym dgym=mlist.get(position);
       // Glide.with(mcontext).asBitmap().load(images.get(position)).into(holder.posttImage);
        ImageView image_id=holder.posttImage;
        TextView name,desc;
        //ClipData.Item item=items.get(position);
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        //holder.postname.setText(postname);
        name=holder.postname;
       // holder.postDescription.setText("mDataset :" +position);
        image_id.setImageResource(dgym.getImage());
        name.setText(dgym.getImage());
       // desc.setText(dgym.getImage());

        holder.cardlayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(mcontext,"Not Yet Available",Toast.LENGTH_SHORT).show();
            }
        });
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() { return mlist.size(); }

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class MyViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        ImageView posttImage;
        TextView postname;
        TextView postDescription;
        LinearLayout cardlayout;
        public MyViewHolder(View itemView) {
            super(itemView);
            posttImage=(ImageView) itemView.findViewById(R.id.image);
            postname=(TextView) itemView.findViewById(R.id.name);
            postDescription=(TextView) itemView.findViewById(R.id.description);
            cardlayout=(LinearLayout) itemView.findViewById(R.id.parent_layout);
        }
    }
   /* public void upadtelist(List<com.example.try2.datagym> newList){
      mlist=new ArrayList<>();
      mlist.add(newList);
      notifyDataSetChanged();

    } */
}
