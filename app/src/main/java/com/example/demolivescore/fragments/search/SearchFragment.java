//package com.example.demolivescore.fragments.search;
//
//import android.os.Bundle;
//
//import androidx.fragment.app.Fragment;
//import androidx.recyclerview.widget.DefaultItemAnimator;
//import androidx.recyclerview.widget.LinearLayoutManager;
//import androidx.recyclerview.widget.RecyclerView;
//
//import android.text.Editable;
//import android.text.TextWatcher;
//import android.util.Log;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.EditText;
//import android.widget.TextView;
//import android.widget.Toast;
//
//import com.example.demolivescore.R;
//import com.example.demolivescore.adapter.SearchAdapter;
//import com.example.demolivescore.dto.CountryDto;
//import com.example.demolivescore.model.Country;
//import com.example.demolivescore.model.CountryData;
//import com.example.demolivescore.service.CountryAPI;
//import com.example.demolivescore.service.RetrofitClient;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import retrofit2.Call;
//import retrofit2.Callback;
//import retrofit2.Response;
//
//public class SearchFragment extends Fragment {
//
//    private static final String TAG = SearchFragment.class.getSimpleName();
//    private CountryAPI countryAPI;
//    private EditText editText;
//    private RecyclerView recyclerView;
//    private List<Country> countries;
//    private SearchAdapter mSearchAdapter;
//
//    public SearchFragment() {
//        // Required empty public constructor
//    }
//
//    public static SearchFragment newInstance(String param1, String param2) {
//        SearchFragment fragment = new SearchFragment();
//        Bundle args = new Bundle();
//        fragment.setArguments(args);
//        return fragment;
//    }
//
//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        countryAPI = RetrofitClient.getClient().create(CountryAPI.class);
//    }
//
//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//        // Inflate the layout for this fragment
//        View view = inflater.inflate(R.layout.fragment_search, container, false);
//        recyclerView = view.findViewById(R.id.search_recycler_view);
//        countries = new ArrayList<>();
//        mSearchAdapter = new SearchAdapter(sear, countries);
//
//        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
//        recyclerView.setLayoutManager(mLayoutManager);
//        recyclerView.setItemAnimator(new DefaultItemAnimator());
//        recyclerView.setAdapter(mSearchAdapter);
//        recyclerView.setNestedScrollingEnabled(false);
//
//        editText = view.findViewById(R.id.editText);
//        editText.addTextChangedListener(new TextWatcher() {
//            @Override
//            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
//
//            }
//
//            @Override
//            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
//
//            }
//
//            @Override
//            public void afterTextChanged(Editable s) {
//                filter(s.toString());
//            }
//        });
//
//        fetchListCountries();
//
//        return view;
//    }
//
//    /**
//     * GET list of countries
//     */
//    private void fetchListCountries() {
//        Call<CountryDto> call = countryAPI.getListOfCountries();
//        call.enqueue(new Callback<CountryDto>() {
//            @Override
//            public void onResponse(Call<CountryDto> call, Response<CountryDto> response) {
//                if (response == null) {
//                    Toast.makeText(getActivity(), "Không thể tải dữ liệu quốc gia", Toast.LENGTH_LONG).show();
//                    return;
//                }
//
//                CountryDto rsDto = response.body();
//                CountryData data = rsDto.getCountryData();
//                for (Country country : data.getCountry()) {
//                    if(country.getName().equals("England") || country.getName().equals("Italy") || country.getName().equals("Spain")
//                            || country.getName().equals("Germany") || country.getName().equals("France")){
//                        countries.add(country);
//                    }
//                }
//                mSearchAdapter = new SearchAdapter(countries);
//
//                // refresh recycler view
//                mSearchAdapter.notifyDataSetChanged();
//            }
//
//            @Override
//            public void onFailure(Call<CountryDto> call, Throwable t) {
//                call.cancel();
//            }
//        });
//    }
//
//    private void filter(String text) {
//        ArrayList<Country> filteredList = new ArrayList<>();
//
//        for (Country item: countries) {
//            if(item.getName().toLowerCase().contains(text.toLowerCase())){
//                filteredList.add(item);
//            }
//        }
//        mSearchAdapter.filterList(filteredList);
//    }
//}