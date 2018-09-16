package com.example.user.droidcafepart3

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { displayMap() }
    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle app bar item clicks here. The app bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        when (item.itemId) {
            R.id.action_order -> {
                displayToast(getString(R.string.action_order_message))
                return true
            }
            R.id.action_status -> {
                displayToast(getString(R.string.action_status_message))
                return true
            }
            R.id.action_favorites -> {
                displayToast(getString(R.string.action_favorites_message))
                return true
            }
            R.id.action_contact -> {
                displayToast(getString(R.string.action_contact_message))
                return true
            }
        }// Do nothing
        return super.onOptionsItemSelected(item)
    }

    /**
     * Shows a message that the donut image was clicked.
     */
    fun showDonutOrder(view: View) {
        showFoodOrder(getString(R.string.donut_order_message))
    }

    /**
     * Shows a message that the ice cream sandwich image was clicked.
     */
    fun showIceCreamOrder(view: View) {
        showFoodOrder(getString(R.string.ice_cream_order_message))
    }

    /**
     * Shows a message that the froyo image was clicked.
     */
    fun showFroyoOrder(view: View) {
        showFoodOrder(getString(R.string.froyo_order_message))
    }

    /**
     * Displays a Toast message for the food order and starts the OrderActivity activity.
     *
     * @param message Message to display.
     */
    fun showFoodOrder(message: String) {
        Toast.makeText(applicationContext, message,
                Toast.LENGTH_SHORT).show()
        val intent = Intent(this, OrderActivity::class.java)
        startActivity(intent)
    }

    fun displayToast(message: String) {
        Toast.makeText(applicationContext, message, Toast.LENGTH_SHORT).show()
    }

    fun displayMap() {
        val intent = Intent()
        intent.action = Intent.ACTION_VIEW
        // Using the coordinates for Google headquarters.
        val data = getString(R.string.google_mtv_coord_zoom12)
        intent.data = Uri.parse(data)
        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        }
    }
}