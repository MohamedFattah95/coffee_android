package com.mohamedfattah95.coffee.ui.main;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.mohamedfattah95.coffee.BuildConfig;
import com.mohamedfattah95.coffee.R;
import com.mohamedfattah95.coffee.data.network.pojo.ProductResponse;
import com.mohamedfattah95.coffee.ui.base.BaseActivity;
import com.mohamedfattah95.coffee.utils.LanguageHelper;

import java.util.HashMap;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity implements MainMvpView, AdditionsAdapter.Callback {

    @Inject
    MainMvpPresenter<MainMvpView> mPresenter;
    @Inject
    LinearLayoutManager linearLayoutManager;
    @Inject
    AdditionsAdapter additionsAdapter;

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.iv_product)
    ImageView ivProduct;
    @BindView(R.id.tv_product_name)
    TextView tvProductName;
    @BindView(R.id.tv_product_price)
    TextView tvProductPrice;
    @BindView(R.id.btn_decrease)
    AppCompatButton btnDecrease;
    @BindView(R.id.tv_product_qty)
    TextView tvProductQty;
    @BindView(R.id.btn_increase)
    AppCompatButton btnIncrease;
    @BindView(R.id.rv_addition)
    RecyclerView rvAddition;
    @BindView(R.id.tv_total_price)
    TextView tvTotalPrice;
    @BindView(R.id.tv_tax)
    TextView tvTax;
    @BindView(R.id.tv_final_price)
    TextView tvFinalPrice;

    ProductResponse.ProductBean product = null;

    String additionIds = "";
    String subAddIds = "";

    HashMap<Integer, Integer> additionsMap = new HashMap<>();


    public static Intent getStartIntent(Context context) {
        return new Intent(context, MainActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        LanguageHelper.setLanguage(this, "ar");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        getActivityComponent().inject(this);
        mPresenter.onAttach(MainActivity.this);
        additionsAdapter.setCallback(this);

        setSupportActionBar(toolbar);


        setUp();

    }

    @Override
    protected void setUp() {

        mPresenter.getProduct("1");

        rvAddition.setLayoutManager(linearLayoutManager);
        rvAddition.setAdapter(additionsAdapter);

    }

    @OnClick({R.id.btn_decrease, R.id.btn_increase, R.id.btn_next})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_decrease:

                if (product == null)
                    return;

                if (Integer.parseInt(tvProductQty.getText().toString()) == 1) {
                    btnDecrease.setEnabled(false);
                    return;
                }

                tvProductQty.setText(String.valueOf(Integer.parseInt(tvProductQty.getText().toString()) - 1));

                tvTotalPrice.setText(String.valueOf(Integer.parseInt(tvProductQty.getText().toString()) *
                        Double.parseDouble(product.getPrice())));

                tvFinalPrice.setText(String.valueOf(Double.parseDouble(tvTotalPrice.getText().toString()) +
                        Double.parseDouble(product.getTax())));


                break;
            case R.id.btn_increase:

                if (product == null)
                    return;

                tvProductQty.setText(String.valueOf(Integer.parseInt(tvProductQty.getText().toString()) + 1));
                btnDecrease.setEnabled(true);

                tvTotalPrice.setText(String.valueOf(Integer.parseInt(tvProductQty.getText().toString()) *
                        Double.parseDouble(product.getPrice())));

                tvFinalPrice.setText(String.valueOf(Double.parseDouble(tvTotalPrice.getText().toString()) +
                        Double.parseDouble(product.getTax())));

                break;
            case R.id.btn_next:

                for (int addition : additionsMap.keySet()) {
                    additionIds += addition + ",";
                    subAddIds += additionsMap.get(addition) + ",";
                }

                if (!additionIds.isEmpty() && !subAddIds.isEmpty()) {
                    additionIds = additionIds.substring(0, additionIds.length() - 1);
                    subAddIds = subAddIds.substring(0, subAddIds.length() - 1);
                }

                mPresenter.makeOrder("1", "1", "1", additionIds, subAddIds, tvProductQty.getText().toString());

                additionIds = "";
                subAddIds = "";

                break;
        }

    }

    @Override
    public void updateProduct(ProductResponse.ProductBean product) {

        this.product = product;

        toolbar.setTitle(product.getTitle());

        if (product.getImg() != null)
            Glide.with(this)
                    .load(BuildConfig.PRODUCT_BASE_URL + product.getImg())
                    .placeholder(R.drawable.ic_coffee)
                    .error(R.drawable.ic_coffee)
                    .into(ivProduct);

        if (product.getTitle() != null)
            tvProductName.setText(product.getTitle());

        if (product.getPrice() != null) {
            tvProductPrice.setText(product.getPrice());
            tvTotalPrice.setText(product.getPrice());
        }

        if (product.getTax() != null) {
            tvTax.setText(product.getTax());
        }

        if (product.getTax() != null && product.getPrice() != null) {
            tvFinalPrice.setText(String.valueOf(Double.parseDouble(product.getPrice()) +
                    Double.parseDouble(product.getTax())));
        }

        additionsAdapter.addItems(product.getAdditions());

    }

    @Override
    public void onAdditionClick(int subAddition, int addition) {

        if (!additionsMap.containsKey(addition) || !additionsMap.containsValue(subAddition))
            additionsMap.put(addition, subAddition);
        else if (additionsMap.containsValue(subAddition))
            additionsMap.remove(addition);


    }
}
