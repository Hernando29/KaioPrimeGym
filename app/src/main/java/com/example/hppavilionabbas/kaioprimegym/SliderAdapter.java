package com.example.hppavilionabbas.kaioprimegym;

import android.content.Context;
import android.provider.ContactsContract;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class SliderAdapter extends PagerAdapter {

    Context context;
    LayoutInflater layoutInflater;


    public SliderAdapter ( Context context)
    {
        this.context = context;
    }


    // arrays

    public int[] slide_images  = {
                R.drawable.bienvenida,
                R.drawable.cuidado,
                R.drawable.entrenar
    };

    public String[]  slide_headings ={

            "BIENVENIDO",
            "CUIDADO",
            "A ENTRENAR"
    };

    public String[] slide_descs = {

            "Te damos la bienvenida al gimnasio KAIO PRIME GYM, " +
                    "la integridad de cada uno de nuestros usuarios es prioritaria siempre y cuando estes bajo nuestra asesoria, " +
                    "ten en cuenta el reglamento del gimnasio al cúal estarás haciendo parte",
            "Si tu realizas alguna actividad fuera de la instrucción de alguno de nuestros instructores de planta en este caso tu intregridad corre por cuenta tuya y no nos hacemos responsables si se ve afectada, " +
                    "sé responsable y organizado con el uso de nuestro equipo deportivo",
            "Nuestros instructores están disponibles para ti, nunca pierdas tus objetivos ni tu motivación; " +
                    "entrena, desacansa, no olvides hidratarte y ten en cuenta siempre tu plan de entrenamiento y nuestra asesoría gracias."

    };




    @Override
    public int getCount() {
        return slide_headings.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == (RelativeLayout) object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position)
    {

            layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            View view = layoutInflater.inflate(R.layout.slide_layout, container, false);

        ImageView  slideImageView = (ImageView) view.findViewById(R.id.slideImage);
        TextView   slideHeading = (TextView) view.findViewById(R.id.slide_heading);
        TextView   slideDesc = (TextView) view.findViewById(R.id.slide_desc);


        slideImageView.setImageResource(slide_images[position]);
        slideHeading.setText(slide_headings[position]);
        slideDesc.setText(slide_descs[position]);

        container.addView(view);

        return view;
    }


    @Override
    public void destroyItem(ViewGroup container, int position, Object object)
    {
        container.removeView((RelativeLayout)object);
    }
}
