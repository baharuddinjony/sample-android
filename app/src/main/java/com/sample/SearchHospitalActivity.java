package com.sample;

import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.widget.EditText;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import java.util.List;

/**
 * Created by User on 2/14/2017.
 */

public class SearchHospitalActivity extends FragmentActivity implements OnMapReadyCallback {

  private GoogleMap mMap;
  @BindView(R.id.searchView1) EditText searchview;
  private double home_long;
  private double home_lat;
  private LatLng latLng;
  private String addressText = null;
  private MarkerOptions markerOptions;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_search_hospital);
    ButterKnife.bind(this);
    SupportMapFragment mapFragment =
        (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
    mapFragment.getMapAsync(this);
  }

  @Override public void onMapReady(GoogleMap googleMap) {
    mMap = googleMap;

    // Add a marker in Sydney and move the camera
    LatLng dhaka = new LatLng(23, 90);
    mMap.addMarker(new MarkerOptions().position(dhaka).title("Marker in Dhaka"));
    mMap.moveCamera(CameraUpdateFactory.newLatLng(dhaka));
  }

  @OnClick(R.id.btn_search_hospitals) public void search() {
    String g = searchview.getText().toString();

    Geocoder geocoder = new Geocoder(getBaseContext());
    List<Address> addresses = null;

    try {
      // Getting a maximum of 3 Address that matches the input
      // text
      addresses = geocoder.getFromLocationName(g, 3);
      if (addresses != null && !addresses.equals("")) search(addresses);
    } catch (Exception e) {

    }
  }

  protected void search(List<Address> addresses) {

    Address address = (Address) addresses.get(0);
    home_long = address.getLongitude();
    home_lat = address.getLatitude();
    latLng = new LatLng(address.getLatitude(), address.getLongitude());

    addressText = String.format("%s, %s",
        address.getMaxAddressLineIndex() > 0 ? address.getAddressLine(0) : "",
        address.getCountryName());

    markerOptions = new MarkerOptions();

    markerOptions.position(latLng);
    markerOptions.title(addressText);

    mMap.clear();
    mMap.addMarker(markerOptions);
    mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));
    mMap.animateCamera(CameraUpdateFactory.zoomTo(15));
    /*locationTv.setText("Latitude:" + address.getLatitude() + ", Longitude:"
        + address.getLongitude());*/

  }
}
