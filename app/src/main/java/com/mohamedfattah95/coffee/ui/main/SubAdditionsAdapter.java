package com.mohamedfattah95.coffee.ui.main;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.github.twocoffeesoneteam.glidetovectoryou.GlideToVectorYou;
import com.mohamedfattah95.coffee.BuildConfig;
import com.mohamedfattah95.coffee.R;
import com.mohamedfattah95.coffee.data.network.pojo.ProductResponse;
import com.mohamedfattah95.coffee.ui.base.BaseViewHolder;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SubAdditionsAdapter extends RecyclerView.Adapter<BaseViewHolder> {

    public static final int VIEW_TYPE_SUB_ADDITION = 1;

    private Callback mCallback;
    private Context context;
    private List<ProductResponse.ProductBean.AdditionsBean.SubAddBean> mSubAdditionList;

    public SubAdditionsAdapter(Context context, List<ProductResponse.ProductBean.AdditionsBean.SubAddBean> subAdd, Callback callback) {
        this.context = context;
        this.mSubAdditionList = subAdd;
        mCallback = callback;
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
                LayoutInflater.from(parent.getContext()).inflate(R.layout.item_sub_addition, parent, false));
    }

    @Override
    public int getItemViewType(int position) {

        return VIEW_TYPE_SUB_ADDITION;

    }

    @Override
    public int getItemCount() {
        return mSubAdditionList.size();

    }

    public void addItems(List<ProductResponse.ProductBean.AdditionsBean.SubAddBean> list) {
        mSubAdditionList.clear();
        mSubAdditionList.addAll(list);
        notifyDataSetChanged();
    }

    public interface Callback {
        void onSubAdditionClick(int id, int subAdd);
    }

    public class AdditionViewHolder extends BaseViewHolder {

        @BindView(R.id.iv_sub_addition)
        ImageView ivSubAddition;
        @BindView(R.id.tv_addition_title)
        TextView tvAdditionTitle;

        public AdditionViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

        }

        protected void clear() {

        }

        public void onBind(int position) {
            super.onBind(position);

            ProductResponse.ProductBean.AdditionsBean.SubAddBean subAddBean = mSubAdditionList.get(position);

            GlideToVectorYou.justLoadImage((Activity) itemView.getContext(),
                    Uri.parse(BuildConfig.ADDITION_BASE_URL + subAddBean.getImg()),
                    ivSubAddition);

            if (subAddBean.isSelected())
                tvAdditionTitle.setTextColor(itemView.getResources().getColor(R.color.black));
            else
                tvAdditionTitle.setTextColor(itemView.getResources().getColor(R.color.aluminum));


            tvAdditionTitle.setText(subAddBean.getTitle());

            itemView.setOnClickListener(view -> {

                subAddBean.setSelected(!subAddBean.isSelected());
                for (int i = 0; i < mSubAdditionList.size(); i++) {
                    if (mSubAdditionList.get(i).getId() != subAddBean.getId()) {
                        mSubAdditionList.get(i).setSelected(false);
                    }
                }

                mCallback.onSubAdditionClick(subAddBean.getId(), subAddBean.getSubAdd());
            });


        }
    }

}
