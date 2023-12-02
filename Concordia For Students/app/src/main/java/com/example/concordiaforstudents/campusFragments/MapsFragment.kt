package com.example.concordiaforstudents.campusFragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.preference.PreferenceManager
import org.osmdroid.api.IMapController
import org.osmdroid.config.Configuration
import org.osmdroid.tileprovider.tilesource.TileSourceFactory
import org.osmdroid.views.MapView
import com.example.concordiaforstudents.R
import org.osmdroid.util.GeoPoint
import org.osmdroid.views.CustomZoomButtonsController
import org.osmdroid.views.overlay.Marker

class MapsFragment : Fragment() {

    lateinit var mapView: MapView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_maps, container, false)

        // Initialize the map view
        mapView = view.findViewById(R.id.mapView)

        // Load and configure the map view
        Configuration.getInstance().load(requireActivity().applicationContext, PreferenceManager.getDefaultSharedPreferences(requireActivity().applicationContext))
        mapView.zoomController.setVisibility(CustomZoomButtonsController.Visibility.SHOW_AND_FADEOUT)

        // Set starting location (Latitude, Longitude) and zoom level
        val startPoint = GeoPoint(45.497253, -73.578944) // Example: New York City
        mapView.controller.setCenter(startPoint)
        mapView.controller.setZoom(20.0)

        // Add a marker to the map
        val startPoint1 = GeoPoint(45.458488, -73.639862) //Loyola
        val startPoint2 = GeoPoint(45.496789, -73.577931) //Webster
        val startPoint3 = GeoPoint(45.495274, -73.579015) //MB
        val startPoint4 = GeoPoint(45.495620, -73.578039) //EV

        addMarker(startPoint)
        addMarker(startPoint1)
        addMarker(startPoint2)
        addMarker(startPoint3)
        addMarker(startPoint4)

        return view
    }

    override fun onResume() {
        super.onResume()
        mapView.onResume()
    }

    override fun onPause() {
        super.onPause()
        mapView.onPause()
    }

    private fun addMarker(geoPoint: GeoPoint) {
        val marker = Marker(mapView)
        marker.position = geoPoint
        marker.setAnchor(Marker.ANCHOR_CENTER, Marker.ANCHOR_BOTTOM)
        mapView.overlays.add(marker)
    }

//    private lateinit var mapView: MapView
//
//    override fun onCreateView(
//        inflater: LayoutInflater, container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//        Log.d("MapsFragment", "onCreateView called")
//
//        // Initialize the map view
//        val ctx = requireActivity().applicationContext
//        Configuration.getInstance().load(ctx, ctx.getSharedPreferences("osm_prefs", 0))
//        Log.d("MapsFragment", "Configuration initialized")
//
//        val view = inflater.inflate(R.layout.fragment_maps, container, false)
//        mapView = view.findViewById(R.id.mapView)
//        Log.d("MapsFragment", "MapView initialized")
//
//        // Set the map center and zoom level
//        val mapController: IMapController = mapView.controller
//        mapController.setZoom(10.0)
//        mapController.setCenter(org.osmdroid.util.GeoPoint(45.4952, -73.5772))
//        Log.d("MapsFragment", "MapController configured")
//
//        return view
//    }

}
