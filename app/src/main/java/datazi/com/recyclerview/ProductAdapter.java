package datazi.com.recyclerview;

/**
 * Created by Ashish on 2/11/2018.
 */

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * RecyclerView.Adapter
 * RecyclerView.ViewHolder
 */
public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {

    private Context context;  //in order to bind xml layout inflater we need context
    private List<Product> productList;
    private RelativeLayout relativeLayout;

    public ProductAdapter(Context context, List<Product> productList) {
        this.context = context;
        this.productList = productList;
    }

    @Override
    public ProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(context);
        View view=inflater.inflate(R.layout.recycler_list,null);
        ProductViewHolder holder=new ProductViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ProductViewHolder holder, int position) {
        //bind data from LIST to Ui
        Product product=productList.get(position);

        //for 1st list object add all ui attributes
        holder.textViewTitle.setText(product.getTitle());
        holder.textViewDesc.setText(product.getShortdesc());
        holder.textViewRating.setText(String.valueOf(product.getRating()));
        holder.textViewPrice.setText(String.valueOf(product.getPrice()));
        holder.relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context,"you clicked",Toast.LENGTH_SHORT).show();
            }
        });

        //for image we need context obj inorder to fetch from drawable folder
        holder.imageView.setImageDrawable(context.getResources().getDrawable(product.getImage()));


    }

    @Override
    public int getItemCount() {

        //size of list
        return productList.size();
    }

    /**
     * for text change listener FIlter List
     * @param filteredList
     * pass new array list and update d sam to existing arraylist
     */
    public  void filterList(ArrayList<Product> filteredList){

        productList=filteredList;
        notifyDataSetChanged();
    }

    //INTERNAL CLASS>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
    public class ProductViewHolder extends RecyclerView.ViewHolder{
        //ui element in order to bind with layout
        ImageView imageView;
        TextView textViewTitle,textViewDesc,textViewRating,textViewPrice;
        RelativeLayout relativeLayout;

        public ProductViewHolder(View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.imageView);
            textViewDesc=itemView.findViewById(R.id.textViewShortDesc);
            textViewPrice=itemView.findViewById(R.id.textViewPrice);
            textViewRating=itemView.findViewById(R.id.textViewRating);
            textViewTitle=itemView.findViewById(R.id.textViewTitle);
            relativeLayout=itemView.findViewById(R.id.relative_layout);
        }
    }


}
