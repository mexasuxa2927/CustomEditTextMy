package com.example.myedittextlib

import android.annotation.SuppressLint
import android.content.Context
import android.content.res.TypedArray
import android.opengl.Visibility
import android.text.InputType
import android.text.method.PasswordTransformationMethod
import android.util.AttributeSet
import android.view.View
import android.widget.EditText
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.widget.AppCompatEditText
@SuppressLint("CustomViewStyleable", "Recycle")
class MyEditText(context: Context, attrs: AttributeSet?) :
    LinearLayout(context,attrs){
    private lateinit var editText: EditText
    private lateinit var icon:ImageView


    init {
            var inflater   = inflate(context,R.layout.my_edit_text,this)
            val atributstype: TypedArray =context.obtainStyledAttributes(attrs,R.styleable.MyEditText)
            val format:Int =atributstype.getInt(R.styleable.MyEditText_inputType_my,0)
            val formatIcon  = atributstype.getInt(R.styleable.MyEditText_myErorIcon,2)
            val formatHint:String   = atributstype.getString(R.styleable.MyEditText_myHint)?:""
            editText  =inflater.findViewById(R.id.edittext)
            icon  =inflater.findViewById(R.id.imageview)
            setFormatEdittext(format)
            setErorIcon(formatIcon)
            setHint(formatHint)

    }

     fun setHint(hint: String) {
        editText.setHint(hint)
    }

     fun setErorIcon(checkText: Int) {
        when(checkText){
            0->{
                icon.visibility  =  View.VISIBLE
                icon.setImageResource(R.drawable.check_symbol_4794)
            }
            1->{
                icon.visibility  = View.VISIBLE
                icon.setImageResource(R.drawable.warning)
            }
            2->{
                icon.visibility  = View.GONE
            }
            else->{
                icon.visibility  = View.GONE
            }
        }
    }


     fun setFormatEdittext(format: Int) {
        when(format){
            0->{
                editText.inputType  = InputType.TYPE_CLASS_TEXT
            }
            1->{
                editText.inputType  = InputType.TYPE_CLASS_PHONE
            }
            2->{
                editText.inputType  = InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS
            }
            3->{
                editText.inputType  = InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD
                editText.transformationMethod =  PasswordTransformationMethod.getInstance()
            }
            else ->{
                editText.inputType   = InputType.TYPE_CLASS_TEXT
            }
        }
    }

    fun setText(string: String) {
        editText.setText(string,TextView.BufferType.EDITABLE)
    }
    fun getText():String{
        return editText.text.toString()
    }


}