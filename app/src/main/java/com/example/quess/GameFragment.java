package com.example.quess;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.quess.databinding.FragmentGameBinding;
import com.example.quess.databinding.FragmentGameBinding;

import java.util.Locale;


public class GameFragment extends Fragment  {



    FragmentGameBinding binding;
    GameModel gameModel;

    public GameFragment(){
    }

    public static GameFragment newInstance(String level) {
        GameFragment fragment = new GameFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    public void OnCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding =FragmentGameBinding.inflate(getLayoutInflater());
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        assert getArguments() != null;
        gameModel = (GameModel) getArguments().getSerializable("game");
        setUI();
        initClickers();
        dialogClickers();
    }

    private void dialogClickers() {
        binding.icHelp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(requireContext())
                        .setTitle("Подказка")
                        .setMessage("Blue")
                        .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                            }
                        })
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .show();
            }
        });
    }

    private void initClickers() {
        binding.applyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (binding.answerEd.getText().toString().trim().equalsIgnoreCase(gameModel.answer)) {
                  Toast.makeText(requireContext(), "Правильно", Toast.LENGTH_SHORT).show();
                }else {
                    binding.answerEd.setError("Вы ошиблись");
               }
            }
        });
    }

    private void setUI() {
        Glide.with(requireContext()).load(gameModel.firstImage).into(binding.firstImg);
        Glide.with(requireContext()).load(gameModel.secondImage).into(binding.secondImg);
        Glide.with(requireContext()).load(gameModel.thirdImage).into(binding.thirdImg);
        Glide.with(requireContext()).load(gameModel.fourImage).into(binding.fourIlm);
        Glide.with(requireContext()).load(gameModel.help).into(binding.icHelp);

    }
}