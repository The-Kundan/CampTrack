package com.example.camptrack;

import android.graphics.Color;
import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.util.ArrayList;

public class MapsFragment extends Fragment {

    private GoogleMap mMap;
    //    private ActivityMapsBinding binding;
    private final OnMapReadyCallback callback = new OnMapReadyCallback() {

        /**
         * Manipulates the map once available.
         * This callback is triggered when the map is ready to be used.
         * This is where we can add markers or lines, add listeners or move the camera.
         * In this case, we just add a marker near Sydney, Australia.
         * If Google Play services is not installed on the device, the user will be prompted to
         * install it inside the SupportMapFragment. This method will only be triggered once the
         * user has installed Google Play services and returned to the app.
         */
        @Override
        public void onMapReady(GoogleMap googleMap) {
            mMap = googleMap;

            // map import to our college using langitude and latitude

            LatLng latLng = new LatLng(30.6809, 76.6054);
            mMap.addMarker(new MarkerOptions().position(latLng).title("Marker At CGC Jhanjeri"));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));
            mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng, 16f));

            mMap.addCircle(new CircleOptions().center(latLng).radius(10).fillColor(Color.WHITE).strokeColor(Color.RED));    // R.Colour.....
            mMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
            mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);

            mMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
                @Override
                public void onMapClick(@NonNull LatLng latLng) {
                    mMap.addMarker(new MarkerOptions().position(latLng).title("Clicked here"));
                    // GeoCoder
                    Geocoder geocoder = new Geocoder(getContext());
                    try {
                        ArrayList<Address> arrAdr = (ArrayList<Address>) geocoder.getFromLocation(latLng.latitude, latLng.longitude, 1);
                        Log.d("Addr", arrAdr.get(0).getAddressLine(0));

                    } catch (IOException e) {
//                   throw new RuntimeException(e);
                        e.printStackTrace();
                    }
                }
            });
        }

//        public void onPointerCaptureChanged(boolean hasCapture) {
//            super.onPointerCaptureChanged(hasCapture);
//        }
    };

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_maps, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        SupportMapFragment mapFragment =
                (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);
        if (mapFragment != null) {
            mapFragment.getMapAsync(callback);
        }
    }
}