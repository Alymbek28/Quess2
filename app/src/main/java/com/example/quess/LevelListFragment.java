package com.example.quess;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.quess.databinding.FragmentLevelListBinding;

import java.util.ArrayList;


public class LevelListFragment extends Fragment implements ItemClickListener {
    FragmentLevelListBinding binding;
    LevelAdapter adapter;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentLevelListBinding.inflate(getLayoutInflater());
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initListener();
        initAdapter();
    }

    private void initAdapter() {
        ArrayList<GameModel> list = new ArrayList<>();
        list.add(new GameModel("https://color.romanuke.com/wp-content/uploads/2019/04/cvetovaya-palitra-4003.png",
                            "https://mixnews.lv/wp-content/uploads/2021/02/3/2021-02-03-mixnews-siniy_manikyur-20-1-696x696.jpg",
                          "https://lookcolor.ru/images/sinij/ottenki_sinego.png",
                        "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTPJWB-eXCe9eOdPJgSKZzQ81xTMprpOiKjLw&usqp=CAU", "Синий",  "1"));
        list.add(new GameModel ("https://im.kommersant.ru/Issues.photo/LifeStyle_Online/2019/07/23/KMO_111307_25971_1_t218_001013.jpg",
                   "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT96gqW33jSwbgnN0R0Ei0IGrvKKaLkMDsX5Q&usqp=CAU",
                   "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ7TgpTMtHpcdAuQgvUv8wpkFc03bFpYduygg&usqp=CAU",
                "https://ria-m.tv/images/news/2021/03/235450.jpg?1629450724", "Лысый", "2"));
        list.add(new GameModel ("https://b1.m24.ru/c/1332719.jpg",
                           "https://fcdynamo.com/img/e0acf744-eb73-48f1-8c63-ce04216b46c2/3533.jpg?fm=jpg&q=80&fit=max&crop=1024%2C768%2C0%2C0",
                         "https://www.ritmeurasia.org/upl/news_image/orig/3x/65/nl/14/3x65nl149g7u.jpg",
                       "https://terrikon.com/i/01/0const/ballstad.jpg", "Футбол", "3"));
        adapter = new LevelAdapter(list, this);
        binding.recyclerView.setAdapter(adapter);
    }

    private void initListener() {
 //    binding.firstLevel.setOnClickListener(new View.OnClickListener() {
   //      @Override
     //    public void onClick(View v) {
       //      GameModel gameModel = new GameModel ("https://color.romanuke.com/wp-content/uploads/2019/04/cvetovaya-palitra-4003.png",
         //            "https://mixnews.lv/wp-content/uploads/2021/02/3/2021-02-03-mixnews-siniy_manikyur-20-1-696x696.jpg",
           //          "https://lookcolor.ru/images/sinij/ottenki_sinego.png",
             //        "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTPJWB-eXCe9eOdPJgSKZzQ81xTMprpOiKjLw&usqp=CAU", "Синий", "level 1");
//             Bundle bundle = new Bundle();
  //           bundle.putSerializable("game", gameModel);
    //         Navigation.findNavController(v).navigate(R.id.gameFragment, bundle);
     //    }
  //   });
//     binding.secondLevel.setOnClickListener(new View.OnClickListener() {
//         @Override
//         public void onClick(View v) {
//             GameModel gameModel = new GameModel ("https://im.kommersant.ru/Issues.photo/LifeStyle_Online/2019/07/23/KMO_111307_25971_1_t218_001013.jpg",
//                     "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT96gqW33jSwbgnN0R0Ei0IGrvKKaLkMDsX5Q&usqp=CAU",
//                     "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ7TgpTMtHpcdAuQgvUv8wpkFc03bFpYduygg&usqp=CAU",
  //                   "https://ria-m.tv/images/news/2021/03/235450.jpg?1629450724", "Лысый", "level 2");
    //         Bundle bundle = new Bundle();
      //       bundle.putSerializable("game", gameModel);
        //     Navigation.findNavController(v).navigate(R.id.gameFragment, bundle);
   //      }
   //  });
     //   binding.thirdLevel.setOnClickListener(new View.OnClickListener() {
       //     @Override
         //   public void onClick(View v) {
           //     GameModel gameModel = new GameModel ("https://b1.m24.ru/c/1332719.jpg",
             //           "https://fcdynamo.com/img/e0acf744-eb73-48f1-8c63-ce04216b46c2/3533.jpg?fm=jpg&q=80&fit=max&crop=1024%2C768%2C0%2C0",
               //         "https://www.ritmeurasia.org/upl/news_image/orig/3x/65/nl/14/3x65nl149g7u.jpg",
                 //       "https://terrikon.com/i/01/0const/ballstad.jpg", "Футбол", "level 3");
        //        Bundle bundle = new Bundle();
          //      bundle.putSerializable("game", gameModel);
            //    Navigation.findNavController(v).navigate(R.id.gameFragment, bundle);
        //    }
       // });
    }


    @Override
    public void itemClick(GameModel model) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("game", model);
        Navigation.findNavController(requireView()).navigate(R.id.gameFragment, bundle);
    }
}