package com.rakaadinugroho.kalkulatorkesehatan;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Rect;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.View;
import android.widget.Toast;

import com.rakaadinugroho.kalkulatorkesehatan.activities.AboutActivity;
import com.rakaadinugroho.kalkulatorkesehatan.activities.BodymessActivity;
import com.rakaadinugroho.kalkulatorkesehatan.activities.WaterActivity;
import com.rakaadinugroho.kalkulatorkesehatan.adapter.MenuAdapter;
import com.rakaadinugroho.kalkulatorkesehatan.model.ObjectMenu;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements MenuAdapter.RecyclerViewItemClickListener {
    private RecyclerView recycler_menu;
    private MenuAdapter menuAdapter;
    private List<ObjectMenu> menuList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        loadMenu();

    }

    private void loadMenu() {
        int[] icons = new int[]{
                R.drawable.weight,
                R.drawable.water,
                R.drawable.calories,
                R.drawable.history,
                R.drawable.about
        };
        ObjectMenu objectMenu   = new ObjectMenu(icons[0], "Berat Ideal");
        menuList.add(objectMenu);
        objectMenu  = new ObjectMenu(icons[1], "Kebutuhan Air");
        menuList.add(objectMenu);
        objectMenu  = new ObjectMenu(icons[2], "Kalori Harian");
        menuList.add(objectMenu);
        objectMenu  = new ObjectMenu(icons[3], "Riwayat");
        menuList.add(objectMenu);
        objectMenu  = new ObjectMenu(icons[4], "Tentang Kami");
        menuList.add(objectMenu);

        menuAdapter.notifyDataSetChanged();

    }

    private void initViews() {
        recycler_menu   = (RecyclerView)findViewById(R.id.recycler_menu);
        menuList    = new ArrayList<>();
        menuAdapter = new MenuAdapter(this, menuList);
        menuAdapter.setRecyclerViewItemClickListener(this);
        RecyclerView.LayoutManager layoutManager    = new GridLayoutManager(this, 2);
        recycler_menu.setLayoutManager(layoutManager);
        recycler_menu.addItemDecoration(new GridSpacingItemDecoration(2, dpToPx(10), true));
        recycler_menu.setItemAnimator(new DefaultItemAnimator());
        recycler_menu.setAdapter(menuAdapter);
    }

    @Override
    public void onItemClick(int position, View view) {
        Intent intent;
        switch (position){
            case 0:
                intent  = new Intent(this, BodymessActivity.class);
                startActivity(intent);
                break;
            case 1:
                intent  = new Intent(this, WaterActivity.class);
                startActivity(intent);
                break;
            case 2:
                Toast.makeText(this, "Comingsoon", Toast.LENGTH_SHORT).show();
                break;
            case 3:
                Toast.makeText(this, "Comingsoon", Toast.LENGTH_SHORT).show();
                break;
            case 4:
                intent  = new Intent(this, AboutActivity.class);
                startActivity(intent);
                break;

        }

    }
    public class GridSpacingItemDecoration extends RecyclerView.ItemDecoration {

        private int spanCount;
        private int spacing;
        private boolean includeEdge;

        public GridSpacingItemDecoration(int spanCount, int spacing, boolean includeEdge) {
            this.spanCount = spanCount;
            this.spacing = spacing;
            this.includeEdge = includeEdge;
        }

        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            int position = parent.getChildAdapterPosition(view); // item position
            int column = position % spanCount; // item column

            if (includeEdge) {
                outRect.left = spacing - column * spacing / spanCount; // spacing - column * ((1f / spanCount) * spacing)
                outRect.right = (column + 1) * spacing / spanCount; // (column + 1) * ((1f / spanCount) * spacing)

                if (position < spanCount) { // top edge
                    outRect.top = spacing;
                }
                outRect.bottom = spacing; // item bottom
            } else {
                outRect.left = column * spacing / spanCount; // column * ((1f / spanCount) * spacing)
                outRect.right = spacing - (column + 1) * spacing / spanCount; // spacing - (column + 1) * ((1f /    spanCount) * spacing)
                if (position >= spanCount) {
                    outRect.top = spacing; // item top
                }
            }
        }
    }
    private int dpToPx(int dp) {
        Resources r = getResources();
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, r.getDisplayMetrics()));
    }
}
