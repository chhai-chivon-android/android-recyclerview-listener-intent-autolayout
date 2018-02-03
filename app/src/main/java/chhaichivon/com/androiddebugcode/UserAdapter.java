package chhaichivon.com.androiddebugcode;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by chhai.chivon on 2/3/2018.
 */

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder> {


    private List<User> users;
    private OnItemClickListener userOnItemClickListener;


    public UserAdapter(List<User> users, OnItemClickListener userOnItemClickListener) {
        this.users = users;
        this.userOnItemClickListener = userOnItemClickListener;
    }

    public UserAdapter(UserAdapter userAdapter) {
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.user_item_layout, parent, false);

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        User user = users.get(position);
        holder.firstName.setText(user.getFirstName());
        holder.lastName.setText(user.getLastName());
        holder.email.setText(user.getEmail());

        holder.bind(users.get(position), userOnItemClickListener);

    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView firstName, lastName, email;

        public ViewHolder(View itemView) {
            super(itemView);
            firstName = itemView.findViewById(R.id.tv_first_name);
            lastName = itemView.findViewById(R.id.tv_last_name);
            email = itemView.findViewById(R.id.tv_email);
        }

        public void bind(final User item, final OnItemClickListener listener) {

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClick(item);
                }
            });

        }

    }


    public interface OnItemClickListener {
        void onItemClick(User item);
    }

}
