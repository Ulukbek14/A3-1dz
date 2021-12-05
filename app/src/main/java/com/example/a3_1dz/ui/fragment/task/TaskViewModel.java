package com.example.a3_1dz.ui.fragment.task;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.a3_1dz.R;
import com.example.a3_1dz.model.TaskModel;

import java.util.ArrayList;

public class TaskViewModel extends ViewModel {

    ArrayList<TaskModel> list = new ArrayList<>();
    public MutableLiveData<ArrayList<TaskModel>> mutableLiveData = new MutableLiveData<>();
    private MutableLiveData<TaskModel> selected = new MutableLiveData<>();

    public void setSelected(TaskModel model){
        selected.setValue(model);
    }

    public MutableLiveData<TaskModel> getSelected(){
        return selected;
    }

    public void getListBooks(){
        list.add(new TaskModel("Audi", "Audi AG ([ˈɑʊdɪ], audi в переводе с лат. — «слушай») — немецкая автомобилестроительная компания в составе концерна Volkswagen Group, специализирующаяся на выпуске автомобилей под маркой Audi. Штаб-квартира расположена в городе Ингольштадт (Германия). Девиз — Vorsprung durch Technik",R.drawable.audi));
        list.add(new TaskModel("BMW", "BMW AG (рус. Бэ-Эм-Вэ́, аббревиатура от Bayerische Motoren Werke AG, с нем. — «Баварские моторные заводы») — немецкий производитель автомобилей, мотоциклов, двигателей, а также велосипедов.", R.drawable.bmw));
        list.add(new TaskModel("Ford","Ford Motor Company — американский автопроизводитель, четвертый в мире по объемам продаж за всю историю. Штаб-квартира базируется в Дирборне, пригороде Детройта, штат Мичиган. Компания была основана Генри Фордом 16 июня 1903 года.", R.drawable.ford));
        list.add(new TaskModel("Honda","Honda Motor Co., 本田技研工業株式会社 хонда гикэн ко:гё кабусики гайся) — японская публичная многонациональная корпорация, основанная в 1948 году изобретателем и предпринимателем Соитиро Хондой и финансистом Такэо Фудзисавой, известная прежде всего как производитель автомобилей, мотоциклов и силового оборудования.", R.drawable.honda));
        list.add(new TaskModel("Hyudai", "Hyundai Motor Company – компания из Южной Кореи, которая производит широкий спектр автомобильной техники. История автопроизводителя началась в 1947 году, когда была открыта фирма по строительству судов. ... В 1976 году, уже заполнив свой рынок, компания начинает экспорт собственных машин в Европу.",R.drawable.hyundai));
        list.add(new TaskModel("Lada","LADA — марка, принадлежащая ОАО «АВТОВАЗ», крупнейшему российскому производителю легковых автомобилей. Сейчас компания находится во владении альянса Renault-Nissan и выпускает автомобили под марками LADA, Renault, Nissan и Datsun. Основное производство и штаб-квартира расположены в городе Тольятти.",R.drawable.lada));
        list.add(new TaskModel("Mazda","«Ма́зда») — японская автомобилестроительная компания, выпускающая автомобили «Мазда». Штаб-квартира расположена в посёлке Футю, уезд Аки, префектура Хиросима, Япония. Входит в кэйрэцу Sumitomo. В 2015 году стала пятнадцатым автопроизводителем в мире по объёму производства автомобилей.",R.drawable.masda));
        mutableLiveData.setValue(list);
    }
}
