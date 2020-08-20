package com.mohamedfattah95.coffee.ui.main;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.mohamedfattah95.coffee.R;
import com.mohamedfattah95.coffee.data.network.pojo.ProductResponse;
import com.mohamedfattah95.coffee.ui.base.BaseViewHolder;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AdditionsAdapter extends RecyclerView.Adapter<BaseViewHolder> {

    public static final int VIEW_TYPE_ADDITION = 1;

    private Callback mCallback;
    private List<ProductResponse.ProductBean.AdditionsBean> mAdditionList;

    public AdditionsAdapter(ArrayList<ProductResponse.ProductBean.AdditionsBean> list) {
        mAdditionList = list;
    }

    public void setCallback(Callback callback) {
        mCallback = callback;
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        holder.onBind(position);
    }

    @NonNull
    @Override
    public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        return new AdditionViewHolder(
                LayoutInflater.from(parent.getContext()).inflate(R.layout.item_addition, parent, false));
    }

    @Override
    public int getItemViewType(int position) {

        return VIEW_TYPE_ADDITION;

    }

    @Override
    public int getItemCount() {
        return mAdditionList.size();

    }

    public void addItems(List<ProductResponse.ProductBean.AdditionsBean> list) {
        mAdditionList.clear();
        mAdditionList.addAll(list);
        notifyDataSetChanged();
    }

    public interface Callback {
        void onAdditionClick(int id, int subAdd);
    }

    public class AdditionViewHolder extends BaseViewHolder implements SubAdditionsAdapter.Callback {

        @BindView(R.id.tv_addition_title)
        TextView tvAdditionTitle;
        @BindView(R.id.rv_sub_addition)
        RecyclerView rvSubAddition;

        SubAdditionsAdapter subAdditionsAdapter;

        public AdditionViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

        }

        protected void clear() {

        }

        public void onBind(int position) {
            super.onBind(position);

            ProductResponse.ProductBean.AdditionsBean additionsBean = mAdditionList.get(position);

            tvAdditionTitle.setText(additionsBean.getTitle());

            rvSubAddition.setLayoutManager(new LinearLayoutManager(itemView.getContext(),
                    LinearLayoutManager.HORIZONTAL, true));

            subAdditionsAdapter = new SubAdditionsAdapter(itemView.getContext(),
                    additionsBean.getSubAdd(), this);

            rvSubAddition.setAdapter(subAdditionsAdapter);


        }

        @Override
        public void onSubAdditionClick(int id, int subAdd) {
            mCallback.onAdditionClick(id, subAdd);
            subAdditionsAdapter.notifyDataSetChanged();
        }
    }

}
