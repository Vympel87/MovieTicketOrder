package com.example.movieticketorder

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.movieticketorder.databinding.ActivityInvoiceBinding
import java.sql.Time

class Invoice : AppCompatActivity() {
    private lateinit var binding: ActivityInvoiceBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityInvoiceBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val title=intent.getStringExtra("Title")
        val image=intent.getIntExtra("Image",0)
        val Date=intent.getStringExtra(Order_Activity.EXTRA_DATE)
        val Time=intent.getStringExtra(Order_Activity.EXTRA_TIME)
        val Seat=intent.getStringExtra(Order_Activity.EXTRA_SEAT)
        val Bioskop=intent.getStringExtra(Order_Activity.EXTRA_BIOSKOP)
        val Fee=intent.getStringExtra(Order_Activity.EXTRA_FEE)
        val TotalPayment=intent.getStringExtra(Order_Activity.EXTRA_TOTAL_PAYMENT)
        val NumberOfSeat=intent.getStringExtra(Order_Activity.EXTRA_NUMBER_OF_SEAT)
        val PaymentMethod=intent.getStringExtra(Order_Activity.EXTRA_METHOD)

        with(binding){
            titleMovie.text=title
            tvBioskop.text=Bioskop
            dateMovie.text=Date+" "+Time
            seat.text=Seat
            payment.text=Fee
            numberOfSeat.text=NumberOfSeat
            totalPayment.text=TotalPayment
            paymentMethod.text=PaymentMethod + " " + "Mobile Banking"
            Glide.with(this@Invoice).load(image).into(imageMovie)
        }
    }
}