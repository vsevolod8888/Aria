package com.example.arria;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.text.Html;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

import java.util.Arrays;
import java.util.Collections;
import java.util.Locale;
import java.util.Random;

public class PlayActivity extends AppCompatActivity {
    Button BtnVar1, BtnVar2, BtnVar3, BtnVar4, BtnVar5, BtnVar6, BtnVar7, BtnVar8, BtnVar9, BtnVar10;
    ImageButton BtnPlay, BtnPause;
    MediaPlayer player;
    Integer rightAnswer;//=1;
    Integer rQuestion1, rQuestion2, rQuestion3, rQuestion4, rQuestion5, rQuestion6, rQuestion7, rQuestion8, rQuestion9, rQuestion10;
    Song song1, song2, song3, song4, song5, song6, song7, song8, song9, song10;
    SongDao dao;
    Context context;
    CountDownTimer mCountDownTimer, mCountDownTimer2;
    TextView tvTimer;
    TextView tvCountAllSeconds;
    TextView tvNameRedScore;
    TextView redScoreCount;
    Handler h;
    boolean wronganswer;

    int timeToThink = 0;
    static long START_TIME_IN_MILLIS = 600000000;
    long mTimeLeftInMillis = START_TIME_IN_MILLIS;
    ImageView hero1, hero2, hero3, hero4, hero5, hero6, hero7, hero8, hero9, hero10, herominus1, herominus2, herominus3, herominus4, herominus5;
    Integer level = 0;
    private static final String TAG = "myLogs";
    long continueTimer;
    private static final String SHARED_PREFS = "sharedPrefs";
    private static final int KEY = 10;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);
        initialize();//в нём UdpadeScore( потом winner()),и 4 setOnClick(selectedvariant(rightAnswer(),wrongAnswer()))
        randomQuestions();
        h = new Handler();
    }

    private void initialize() {

        BtnVar1 = (Button) findViewById(R.id.button_var_1);
        BtnVar2 = (Button) findViewById(R.id.button_var_2);
        BtnVar3 = (Button) findViewById(R.id.button_var_3);
        BtnVar4 = (Button) findViewById(R.id.button_var_4);
        BtnVar5 = (Button) findViewById(R.id.button_var_5);
        BtnVar6 = (Button) findViewById(R.id.button_var_6);
        BtnVar7 = (Button) findViewById(R.id.button_var_7);
        BtnVar8 = (Button) findViewById(R.id.button_var_8);
        BtnVar9 = (Button) findViewById(R.id.button_var_9);
        BtnVar10 = (Button) findViewById(R.id.button_var_10);
        BtnPlay = (ImageButton) findViewById(R.id.button_start_to_play);
        BtnPause = (ImageButton) findViewById(R.id.button_pause);
        tvTimer = (TextView) findViewById(R.id.tvTimer);
        tvCountAllSeconds = (TextView) findViewById(R.id.seconds_count_2);
        tvNameRedScore = (TextView) findViewById(R.id.tv_name_red_score);
        redScoreCount = (TextView) findViewById(R.id.seconds_count_red);
        hero1 = (ImageView) findViewById(R.id.hero1);
        hero2 = (ImageView) findViewById(R.id.hero2);
        hero3 = (ImageView) findViewById(R.id.hero3);
        hero4 = (ImageView) findViewById(R.id.hero4);
        hero5 = (ImageView) findViewById(R.id.hero5);
        hero6 = (ImageView) findViewById(R.id.hero6);
        hero7 = (ImageView) findViewById(R.id.hero7);
        hero8 = (ImageView) findViewById(R.id.hero8);
        hero9 = (ImageView) findViewById(R.id.hero9);
        hero10 = (ImageView) findViewById(R.id.hero10);
        herominus1 = (ImageView) findViewById(R.id.hero_minus_1);
        herominus2 = (ImageView) findViewById(R.id.hero_minus_2);
        herominus3 = (ImageView) findViewById(R.id.hero_minus_3);
        herominus4 = (ImageView) findViewById(R.id.hero_minus_4);
        herominus5 = (ImageView) findViewById(R.id.hero_minus_5);
        Animation animZoomIn = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoom_play);
        BtnPlay.startAnimation(animZoomIn);
        BtnVar1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                stopPlayer();
                doPlayVisible();
                selectedVarriant(1);
            }
        });
        BtnVar2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                stopPlayer();
                doPlayVisible();
                selectedVarriant(2);
            }
        });
        BtnVar3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                stopPlayer();
                doPlayVisible();
                selectedVarriant(3);
            }
        });
        BtnVar4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                stopPlayer();
                doPlayVisible();
                selectedVarriant(4);
            }
        });
        BtnVar5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                stopPlayer();
                doPlayVisible();
                selectedVarriant(5);
            }
        });
        BtnVar6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                stopPlayer();
                doPlayVisible();
                selectedVarriant(6);
            }
        });
        BtnVar7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                stopPlayer();
                doPlayVisible();
                selectedVarriant(7);
            }
        });
        BtnVar8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                stopPlayer();
                doPlayVisible();
                selectedVarriant(8);
            }
        });
        BtnVar9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                stopPlayer();
                doPlayVisible();
                selectedVarriant(9);
            }
        });
        BtnVar10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                stopPlayer();
                doPlayVisible();
                selectedVarriant(10);
            }
        });
    }

    private void selectedVarriant(Integer selectedVariant) {
        if (selectedVariant.equals(rightAnswer)) {
            rightAnswer();
        } else {
            wrongAnswer();
        }
    }

    private void rightAnswer() {
        stopTimer();
        stopTimer2();
        level++;
        setLevelVisibility();
        Log.d(TAG, String.valueOf(level));
        if (level >= 10) {
            try {
                //   TimeUnit.SECONDS.sleep(2);
                winner();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
        randomQuestions();
    }

    private void wrongAnswer() {
        wronganswer = true;
        level--;
        setLevelVisibility();
        stopTimer();
        stopTimer2();
        showTrueAnswer();
        BtnPlay.clearAnimation();
        BtnPlay.setVisibility(View.INVISIBLE);
        BtnPause.setVisibility(View.INVISIBLE);
        // doPauseVisible();
        h.postDelayed(new Runnable() {
            @Override
            public void run() {
                //    BtnPlay.setVisibility(View.INVISIBLE);
                doPlayVisible();

                randomQuestions();

            }
        }, 1500);

    }

    private void randomQuestions() {
        Integer[] arr = new Integer[121];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
        }
        Collections.shuffle(Arrays.asList(arr));
        rQuestion1 = arr[0];//чтобы не получился ноль
        rQuestion2 = arr[1];
        rQuestion3 = arr[2];
        rQuestion4 = arr[3];
        rQuestion5 = arr[4];
        rQuestion6 = arr[5];
        rQuestion7 = arr[6];
        rQuestion8 = arr[7];
        rQuestion9 = arr[8];
        rQuestion10 = arr[9];
        Random random = new Random();
        rightAnswer = random.nextInt(10 - 1) + 1;
        nextQuestion(rQuestion1, rQuestion2, rQuestion3, rQuestion4, rQuestion5, rQuestion6, rQuestion7, rQuestion8, rQuestion9, rQuestion10, rightAnswer);
    }

    private void nextQuestion(Integer rQuestion1, Integer rQuestion2, Integer rQuestion3, Integer rQuestion4, Integer rQuestion5, Integer rQuestion6, Integer rQuestion7, Integer rQuestion8, Integer rQuestion9, Integer rQuestion10, Integer rightAnswer) {
        dao = SongsDB.getInstance(this).songDao();
        resetButtonColor();
        song1 = dao.getSongById(rQuestion1);
        song2 = dao.getSongById(rQuestion2);
        song3 = dao.getSongById(rQuestion3);
        song4 = dao.getSongById(rQuestion4);
        song5 = dao.getSongById(rQuestion5);
        song6 = dao.getSongById(rQuestion6);
        song7 = dao.getSongById(rQuestion7);
        song8 = dao.getSongById(rQuestion8);
        song9 = dao.getSongById(rQuestion9);
        song10 = dao.getSongById(rQuestion10);
        BtnVar1.setText(song1.getSongName());
        BtnVar2.setText(song2.getSongName());
        BtnVar3.setText(song3.getSongName());
        BtnVar4.setText(song4.getSongName());
        BtnVar5.setText(song5.getSongName());
        BtnVar6.setText(song6.getSongName());
        BtnVar7.setText(song7.getSongName());
        BtnVar8.setText(song8.getSongName());
        BtnVar9.setText(song9.getSongName());
        BtnVar10.setText(song10.getSongName());
        switch (rightAnswer) {
            case 1:
                BtnPlay.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String s = song1.getFileName();
                        toPlay(s);
                        doPauseVisible();
                        BtnPlay.clearAnimation();

                        startTimer(START_TIME_IN_MILLIS);
                        startTimer2();
                    }
                });
                BtnPause.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        pauseMusic();
                        doPlayVisible();
                    }
                });
                break;
            case 2:
                BtnPlay.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        String s = song2.getFileName();
                        toPlay(s);

                        doPauseVisible();
                        startTimer(START_TIME_IN_MILLIS);
                        startTimer2();
                        BtnPlay.clearAnimation();
                    }

                });
                BtnPause.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        pauseMusic();
                        doPlayVisible();
                    }
                });
                break;
            case 3:
                BtnPlay.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        String s = song3.getFileName();
                        toPlay(s);

                        doPauseVisible();
                        startTimer(START_TIME_IN_MILLIS);
                        startTimer2();
                        BtnPlay.clearAnimation();
                    }

                });
                BtnPause.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        pauseMusic();
                        doPlayVisible();
                    }
                });
                break;
            case 4:
                BtnPlay.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        String s = song4.getFileName();
                        toPlay(s);

                        doPauseVisible();
                        startTimer(START_TIME_IN_MILLIS);
                        startTimer2();
                        BtnPlay.clearAnimation();
                    }
                });
                BtnPause.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        pauseMusic();
                        doPlayVisible();
                    }
                });
                break;
            case 5:
                BtnPlay.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        String s = song5.getFileName();
                        toPlay(s);
                        doPauseVisible();
                        startTimer(START_TIME_IN_MILLIS);
                        startTimer2();
                        BtnPlay.clearAnimation();
                    }
                });
                BtnPause.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        pauseMusic();
                        doPlayVisible();
                    }
                });
                break;
            case 6:
                BtnPlay.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        String s = song6.getFileName();
                        toPlay(s);
                        doPauseVisible();
                        startTimer(START_TIME_IN_MILLIS);
                        startTimer2();
                        BtnPlay.clearAnimation();
                    }
                });
                BtnPause.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        pauseMusic();
                        doPlayVisible();
                    }
                });
                break;
            case 7:
                BtnPlay.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        String s = song7.getFileName();
                        toPlay(s);
                        doPauseVisible();
                        startTimer(START_TIME_IN_MILLIS);
                        startTimer2();
                        BtnPlay.clearAnimation();
                    }
                });
                BtnPause.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        pauseMusic();
                        doPlayVisible();
                    }
                });
                break;
            case 8:
                BtnPlay.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        String s = song8.getFileName();
                        toPlay(s);
                        doPauseVisible();
                        startTimer(START_TIME_IN_MILLIS);
                        startTimer2();
                        BtnPlay.clearAnimation();
                    }
                });
                BtnPause.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        pauseMusic();
                        doPlayVisible();
                    }
                });
                break;
            case 9:
                BtnPlay.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String s = song9.getFileName();
                        toPlay(s);
                        doPauseVisible();
                        startTimer(START_TIME_IN_MILLIS);
                        startTimer2();
                        BtnPlay.clearAnimation();
                    }
                });
                BtnPause.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        pauseMusic();
                        doPlayVisible();

                    }
                });
                break;
            case 10:
                BtnPlay.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        String s = song10.getFileName();
                        toPlay(s);
                        doPauseVisible();
                        startTimer(START_TIME_IN_MILLIS);
                        startTimer2();
                        BtnPlay.clearAnimation();
                    }
                });
                BtnPause.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        pauseMusic();
                        doPlayVisible();
                    }
                });
                break;

        }
    }


    private void toPlay(String s) {
        if (player == null) {
            player = MediaPlayer.create(this, getResources().getIdentifier(s, "raw", getPackageName()));
            player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    stopPlayer();
                    if (wronganswer==false) {//при неправильном ответе мы не делаем плей VISIBLE
                        doPlayVisible();
                        wronganswer = false;
                    }
                }
            });
        }
        player.start();       //плеер != null, поэтому эта строка здесь, а не после;
    }

    private void stopPlayer() {
        if (player != null) {
            player.release();//вместо того, чтобы держать наш экземпляр медиаплеера, мы его освобождаем(release)
            player = null;   //и создаём новый, когда нажимаем play
        }
        doPlayVisible();
    }

    protected void onStop() {  //когда покидаем приложение, тоже выполняется stopPlayer()
        super.onStop();
        stopPlayer();
    }


    protected void doPauseVisible() {
        BtnPlay.setVisibility(View.INVISIBLE);
        BtnPause.setVisibility(View.VISIBLE);
    }

    protected void doPlayVisible() {
        BtnPause.setVisibility(View.INVISIBLE);
        BtnPlay.setVisibility(View.VISIBLE);
    }

    protected void pauseMusic() {
        if (player != null) {
            player.pause();
        }
    }

    private void startTimer(final long mTimeLeftInMillis) {
        if (mCountDownTimer != null) {
           return;                 //return передаёт управление объекту, который вызвал данный метод
           // mCountDownTimer.cancel();                                        //то новый не создавать
        }
        mCountDownTimer = new CountDownTimer(mTimeLeftInMillis, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                long m = mTimeLeftInMillis - millisUntilFinished; //60000 - 59000 = 1000
                updateOurCountDownText(m); //передаём 1

            }

            @Override
            public void onFinish() {

            }
        }.start();
    }

    private void startTimer2() {
          if(mCountDownTimer2!=null) {
              mCountDownTimer2.cancel();
          }                      //если таймер уже существует
                  mCountDownTimer2 = new CountDownTimer(mTimeLeftInMillis, 1000) {

                      @Override
                      public void onTick(long millisUntilFinished) {
                          mTimeLeftInMillis = millisUntilFinished;
                          long ggg = START_TIME_IN_MILLIS - millisUntilFinished;
                          ;                                                     //????
                          updateOurCountDownText2(ggg); //передаём 1

                      }

                      @Override
                      public void onFinish() {

                      }
                  } .start();
    }

    private void updateOurCountDownText(long m) {
        int minutes = (int) (m / 1000) / 60;// из миллисекунд, кот.остались до конца получаем минуты
        int seconds = (int) (m / 1000) % 60;//получаем секунды, напр.2%60 =2,
        String timeLeftFormatted = String.format(Locale.getDefault(), "%2d:%02d", minutes, seconds);
        tvTimer.setText(timeLeftFormatted);

    }

    private void updateOurCountDownText2(long m) {
        int minutes = (int) (m / 1000) / 60;// из миллисекунд, кот.остались до конца получаем минуты
        int seconds = (int) (m / 1000) % 60;//получаем секунды, напр.2%60 =2,
        String timeLeftFormatted = String.format(Locale.getDefault(), "%2d:%02d", minutes, seconds);
        tvCountAllSeconds.setText(timeLeftFormatted);
    }

    private void stopTimer() {
        if (mCountDownTimer != null) {
            mCountDownTimer.cancel();
            mCountDownTimer = null;
        }
    }
    private void stopTimer2() {
        if (mCountDownTimer2 != null) {
            mCountDownTimer2.cancel();
            mCountDownTimer2 = null;
        }
    }
    private void setLevelVisibility() {
        if (level == 1) {
            tvNameRedScore.setVisibility(View.INVISIBLE);
            redScoreCount.setVisibility(View.INVISIBLE);
            hero1.setVisibility(View.VISIBLE);
            hero2.setVisibility(View.INVISIBLE);
            hero3.setVisibility(View.INVISIBLE);
            hero4.setVisibility(View.INVISIBLE);
            hero5.setVisibility(View.INVISIBLE);
            hero6.setVisibility(View.INVISIBLE);
            hero7.setVisibility(View.INVISIBLE);
            hero9.setVisibility(View.INVISIBLE);
            hero10.setVisibility(View.INVISIBLE);
            herominus1.setVisibility(View.INVISIBLE);
            herominus2.setVisibility(View.INVISIBLE);
            herominus3.setVisibility(View.INVISIBLE);
            herominus4.setVisibility(View.INVISIBLE);
            herominus5.setVisibility(View.INVISIBLE);
        } else if (level == 2) {
            tvNameRedScore.setVisibility(View.INVISIBLE);
            redScoreCount.setVisibility(View.INVISIBLE);
            hero1.setVisibility(View.VISIBLE);
            hero2.setVisibility(View.VISIBLE);
            hero3.setVisibility(View.INVISIBLE);
            hero4.setVisibility(View.INVISIBLE);
            hero5.setVisibility(View.INVISIBLE);
            hero6.setVisibility(View.INVISIBLE);
            hero7.setVisibility(View.INVISIBLE);
            hero8.setVisibility(View.INVISIBLE);
            hero9.setVisibility(View.INVISIBLE);
            hero10.setVisibility(View.INVISIBLE);
            herominus1.setVisibility(View.INVISIBLE);
            herominus2.setVisibility(View.INVISIBLE);
            herominus3.setVisibility(View.INVISIBLE);
            herominus4.setVisibility(View.INVISIBLE);
            herominus5.setVisibility(View.INVISIBLE);
        } else if (level == 3) {
            tvNameRedScore.setVisibility(View.INVISIBLE);
            redScoreCount.setVisibility(View.INVISIBLE);
            hero1.setVisibility(View.VISIBLE);
            hero2.setVisibility(View.VISIBLE);
            hero3.setVisibility(View.VISIBLE);
            hero4.setVisibility(View.INVISIBLE);
            hero5.setVisibility(View.INVISIBLE);
            hero6.setVisibility(View.INVISIBLE);
            hero7.setVisibility(View.INVISIBLE);
            hero8.setVisibility(View.INVISIBLE);
            hero9.setVisibility(View.INVISIBLE);
            hero10.setVisibility(View.INVISIBLE);
            herominus1.setVisibility(View.INVISIBLE);
            herominus2.setVisibility(View.INVISIBLE);
            herominus3.setVisibility(View.INVISIBLE);
            herominus4.setVisibility(View.INVISIBLE);
            herominus5.setVisibility(View.INVISIBLE);
        } else if (level == 4) {
            tvNameRedScore.setVisibility(View.INVISIBLE);
            redScoreCount.setVisibility(View.INVISIBLE);
            hero1.setVisibility(View.VISIBLE);
            hero2.setVisibility(View.VISIBLE);
            hero3.setVisibility(View.VISIBLE);
            hero4.setVisibility(View.VISIBLE);
            hero5.setVisibility(View.INVISIBLE);
            hero6.setVisibility(View.INVISIBLE);
            hero8.setVisibility(View.INVISIBLE);
            hero9.setVisibility(View.INVISIBLE);
            hero10.setVisibility(View.INVISIBLE);
            herominus1.setVisibility(View.INVISIBLE);
            herominus2.setVisibility(View.INVISIBLE);
            herominus3.setVisibility(View.INVISIBLE);
            herominus4.setVisibility(View.INVISIBLE);
            herominus5.setVisibility(View.INVISIBLE);
        } else if (level == 5) {
            tvNameRedScore.setVisibility(View.INVISIBLE);
            redScoreCount.setVisibility(View.INVISIBLE);
            hero1.setVisibility(View.VISIBLE);
            hero2.setVisibility(View.VISIBLE);
            hero3.setVisibility(View.VISIBLE);
            hero4.setVisibility(View.VISIBLE);
            hero5.setVisibility(View.VISIBLE);
            hero6.setVisibility(View.INVISIBLE);
            hero7.setVisibility(View.INVISIBLE);
            hero8.setVisibility(View.INVISIBLE);
            hero9.setVisibility(View.INVISIBLE);
            hero10.setVisibility(View.INVISIBLE);
            herominus1.setVisibility(View.INVISIBLE);
            herominus2.setVisibility(View.INVISIBLE);
            herominus3.setVisibility(View.INVISIBLE);
            herominus4.setVisibility(View.INVISIBLE);
            herominus5.setVisibility(View.INVISIBLE);
        } else if (level == 6) {
            tvNameRedScore.setVisibility(View.INVISIBLE);
            redScoreCount.setVisibility(View.INVISIBLE);
            hero1.setVisibility(View.VISIBLE);
            hero2.setVisibility(View.VISIBLE);
            hero3.setVisibility(View.VISIBLE);
            hero4.setVisibility(View.VISIBLE);
            hero5.setVisibility(View.VISIBLE);
            hero6.setVisibility(View.VISIBLE);
            hero7.setVisibility(View.INVISIBLE);
            hero8.setVisibility(View.INVISIBLE);
            hero9.setVisibility(View.INVISIBLE);
            hero10.setVisibility(View.INVISIBLE);
            herominus1.setVisibility(View.INVISIBLE);
            herominus2.setVisibility(View.INVISIBLE);
            herominus3.setVisibility(View.INVISIBLE);
            herominus4.setVisibility(View.INVISIBLE);
            herominus5.setVisibility(View.INVISIBLE);
        } else if (level == 7) {
            tvNameRedScore.setVisibility(View.INVISIBLE);
            redScoreCount.setVisibility(View.INVISIBLE);
            hero1.setVisibility(View.VISIBLE);
            hero2.setVisibility(View.VISIBLE);
            hero3.setVisibility(View.VISIBLE);
            hero4.setVisibility(View.VISIBLE);
            hero5.setVisibility(View.VISIBLE);
            hero6.setVisibility(View.VISIBLE);
            hero7.setVisibility(View.VISIBLE);
            hero8.setVisibility(View.INVISIBLE);
            hero9.setVisibility(View.INVISIBLE);
            hero10.setVisibility(View.INVISIBLE);
            herominus1.setVisibility(View.INVISIBLE);
            herominus2.setVisibility(View.INVISIBLE);
            herominus3.setVisibility(View.INVISIBLE);
            herominus4.setVisibility(View.INVISIBLE);
            herominus5.setVisibility(View.INVISIBLE);
        } else if (level == 8) {
            tvNameRedScore.setVisibility(View.INVISIBLE);
            redScoreCount.setVisibility(View.INVISIBLE);
            hero1.setVisibility(View.VISIBLE);
            hero2.setVisibility(View.VISIBLE);
            hero3.setVisibility(View.VISIBLE);
            hero4.setVisibility(View.VISIBLE);
            hero5.setVisibility(View.VISIBLE);
            hero6.setVisibility(View.VISIBLE);
            hero7.setVisibility(View.VISIBLE);
            hero8.setVisibility(View.VISIBLE);
            hero9.setVisibility(View.INVISIBLE);
            hero10.setVisibility(View.INVISIBLE);
            herominus1.setVisibility(View.INVISIBLE);
            herominus2.setVisibility(View.INVISIBLE);
            herominus3.setVisibility(View.INVISIBLE);
            herominus4.setVisibility(View.INVISIBLE);
            herominus5.setVisibility(View.INVISIBLE);
        } else if (level == 9) {
            tvNameRedScore.setVisibility(View.INVISIBLE);
            redScoreCount.setVisibility(View.INVISIBLE);
            hero1.setVisibility(View.VISIBLE);
            hero2.setVisibility(View.VISIBLE);
            hero3.setVisibility(View.VISIBLE);
            hero4.setVisibility(View.VISIBLE);
            hero5.setVisibility(View.VISIBLE);
            hero6.setVisibility(View.VISIBLE);
            hero7.setVisibility(View.VISIBLE);
            hero8.setVisibility(View.VISIBLE);
            hero9.setVisibility(View.VISIBLE);
            herominus1.setVisibility(View.INVISIBLE);
            herominus2.setVisibility(View.INVISIBLE);
            herominus3.setVisibility(View.INVISIBLE);
            herominus4.setVisibility(View.INVISIBLE);
            herominus5.setVisibility(View.INVISIBLE);
        } else if (level == 10) {
            tvNameRedScore.setVisibility(View.INVISIBLE);
            redScoreCount.setVisibility(View.INVISIBLE);
            hero1.setVisibility(View.VISIBLE);
            hero2.setVisibility(View.VISIBLE);
            hero3.setVisibility(View.VISIBLE);
            hero4.setVisibility(View.VISIBLE);
            hero5.setVisibility(View.VISIBLE);
            hero6.setVisibility(View.VISIBLE);
            hero7.setVisibility(View.VISIBLE);
            hero8.setVisibility(View.VISIBLE);
            hero9.setVisibility(View.VISIBLE);
            hero10.setVisibility(View.VISIBLE);
            herominus1.setVisibility(View.INVISIBLE);
            herominus2.setVisibility(View.INVISIBLE);
            herominus3.setVisibility(View.INVISIBLE);
            herominus4.setVisibility(View.INVISIBLE);
            herominus5.setVisibility(View.INVISIBLE);
        } else if (level == 0) {
            tvNameRedScore.setVisibility(View.INVISIBLE);
            redScoreCount.setVisibility(View.INVISIBLE);
            hero1.setVisibility(View.INVISIBLE);
            hero2.setVisibility(View.INVISIBLE);
            hero3.setVisibility(View.INVISIBLE);
            hero4.setVisibility(View.INVISIBLE);
            hero5.setVisibility(View.INVISIBLE);
            hero6.setVisibility(View.INVISIBLE);
            hero7.setVisibility(View.INVISIBLE);
            hero9.setVisibility(View.INVISIBLE);
            hero10.setVisibility(View.INVISIBLE);
            herominus1.setVisibility(View.INVISIBLE);
            herominus2.setVisibility(View.INVISIBLE);
            herominus3.setVisibility(View.INVISIBLE);
            herominus4.setVisibility(View.INVISIBLE);
            herominus5.setVisibility(View.INVISIBLE);
        } else if (level == -1) {
            tvNameRedScore.setVisibility(View.VISIBLE);
            redScoreCount.setVisibility(View.VISIBLE);
            redScoreCount.setText(Integer.toString(level));
            hero1.setVisibility(View.INVISIBLE);
            hero2.setVisibility(View.INVISIBLE);
            hero3.setVisibility(View.INVISIBLE);
            hero4.setVisibility(View.INVISIBLE);
            hero5.setVisibility(View.INVISIBLE);
            hero6.setVisibility(View.INVISIBLE);
            hero7.setVisibility(View.INVISIBLE);
            hero9.setVisibility(View.INVISIBLE);
            hero10.setVisibility(View.INVISIBLE);
            herominus1.setVisibility(View.VISIBLE);
            herominus2.setVisibility(View.INVISIBLE);
            herominus3.setVisibility(View.INVISIBLE);
            herominus4.setVisibility(View.INVISIBLE);
            herominus5.setVisibility(View.INVISIBLE);
        } else if (level == -2) {
            tvNameRedScore.setVisibility(View.VISIBLE);
            redScoreCount.setVisibility(View.VISIBLE);
            redScoreCount.setText(Integer.toString(level));
            hero1.setVisibility(View.INVISIBLE);
            hero2.setVisibility(View.INVISIBLE);
            hero3.setVisibility(View.INVISIBLE);
            hero4.setVisibility(View.INVISIBLE);
            hero5.setVisibility(View.INVISIBLE);
            hero6.setVisibility(View.INVISIBLE);
            hero7.setVisibility(View.INVISIBLE);
            hero9.setVisibility(View.INVISIBLE);
            hero10.setVisibility(View.INVISIBLE);
            herominus1.setVisibility(View.VISIBLE);
            herominus2.setVisibility(View.VISIBLE);
            herominus3.setVisibility(View.INVISIBLE);
            herominus4.setVisibility(View.INVISIBLE);
            herominus5.setVisibility(View.INVISIBLE);
        } else if (level == -3) {
            tvNameRedScore.setVisibility(View.VISIBLE);
            redScoreCount.setVisibility(View.VISIBLE);
            redScoreCount.setText(Integer.toString(level));
            hero1.setVisibility(View.INVISIBLE);
            hero2.setVisibility(View.INVISIBLE);
            hero3.setVisibility(View.INVISIBLE);
            hero4.setVisibility(View.INVISIBLE);
            hero5.setVisibility(View.INVISIBLE);
            hero6.setVisibility(View.INVISIBLE);
            hero7.setVisibility(View.INVISIBLE);
            hero9.setVisibility(View.INVISIBLE);
            hero10.setVisibility(View.INVISIBLE);
            herominus1.setVisibility(View.VISIBLE);
            herominus2.setVisibility(View.VISIBLE);
            herominus3.setVisibility(View.VISIBLE);
            herominus4.setVisibility(View.INVISIBLE);
            herominus5.setVisibility(View.INVISIBLE);
        } else if (level == -4) {
            tvNameRedScore.setVisibility(View.VISIBLE);
            redScoreCount.setVisibility(View.VISIBLE);
            redScoreCount.setText(Integer.toString(level));
            hero1.setVisibility(View.INVISIBLE);
            hero2.setVisibility(View.INVISIBLE);
            hero3.setVisibility(View.INVISIBLE);
            hero4.setVisibility(View.INVISIBLE);
            hero5.setVisibility(View.INVISIBLE);
            hero6.setVisibility(View.INVISIBLE);
            hero7.setVisibility(View.INVISIBLE);
            hero9.setVisibility(View.INVISIBLE);
            hero10.setVisibility(View.INVISIBLE);
            herominus1.setVisibility(View.VISIBLE);
            herominus2.setVisibility(View.VISIBLE);
            herominus3.setVisibility(View.VISIBLE);
            herominus4.setVisibility(View.VISIBLE);
            herominus5.setVisibility(View.INVISIBLE);
        } else if (level == -5) {
            tvNameRedScore.setVisibility(View.VISIBLE);
            redScoreCount.setVisibility(View.VISIBLE);
            redScoreCount.setText(Integer.toString(level));
            hero1.setVisibility(View.INVISIBLE);
            hero2.setVisibility(View.INVISIBLE);
            hero3.setVisibility(View.INVISIBLE);
            hero4.setVisibility(View.INVISIBLE);
            hero5.setVisibility(View.INVISIBLE);
            hero6.setVisibility(View.INVISIBLE);
            hero7.setVisibility(View.INVISIBLE);
            hero9.setVisibility(View.INVISIBLE);
            hero10.setVisibility(View.INVISIBLE);
            herominus1.setVisibility(View.VISIBLE);
            herominus2.setVisibility(View.VISIBLE);
            herominus3.setVisibility(View.VISIBLE);
            herominus4.setVisibility(View.VISIBLE);
            herominus5.setVisibility(View.VISIBLE);
            loosing();
        }
    }

    @SuppressLint("ResourceAsColor")
    private void winner() throws InterruptedException {
        SharedPreferences sharedPreferences = PreferenceManager
                .getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Long countPut = START_TIME_IN_MILLIS - mTimeLeftInMillis;
        Long countBring = sharedPreferences.getLong(String.valueOf(KEY), Long.MAX_VALUE);
        if (countPut < countBring) {
            editor.putLong(String.valueOf(KEY), countPut);
        }
        editor.apply();
        AlertDialog.Builder builder = new AlertDialog.Builder(PlayActivity.this, R.style.AlertDialogTheme);

        builder.setTitle("Победа! Ваше время: " + tvCountAllSeconds.getText().toString())
                .setCancelable(false)
                .setPositiveButton("Выход", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();

                    }
                })
                .setNeutralButton("Играть", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                        Intent ma = new Intent(getBaseContext(), PlayActivity.class);
                        startActivity(ma);
                    }
                });
        final AlertDialog alert = builder.create();

        alert.setOnShowListener(new DialogInterface.OnShowListener() {
            @Override
            public void onShow(DialogInterface dialog) {
                Button btnPositive = alert.getButton(Dialog.BUTTON_POSITIVE);
                btnPositive.setTextSize(31);

                Button btnNeuteral = alert.getButton(Dialog.BUTTON_NEUTRAL);
                btnNeuteral.setTextSize(31);
            }
        });

        alert.show();

        alert.getWindow().setBackgroundDrawableResource(R.drawable.alert_image);

        int textViewId = alert.getContext().getResources().getIdentifier("android:id/alertTitle", null, null);
        TextView tv = (TextView) alert.findViewById(textViewId);
        tv.setTextColor(getResources().getColor(R.color.allert_color));
    }

    private void loosing() {
        AlertDialog.Builder builder = new AlertDialog.Builder(PlayActivity.this, R.style.AlertDialogLooseTheme);

        builder.setTitle("Вы проиграли.Ваш уровень: " + redScoreCount.getText().toString())
                .setCancelable(false)
                .setPositiveButton("Выход", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();

                    }
                })
                .setNeutralButton("Играть", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                        Intent ma = new Intent(getBaseContext(), PlayActivity.class);
                        startActivity(ma);
                    }
                });
        final AlertDialog alert = builder.create();

        alert.setOnShowListener(new DialogInterface.OnShowListener() {
            @Override
            public void onShow(DialogInterface dialog) {
                Button btnPositive = alert.getButton(Dialog.BUTTON_POSITIVE);
                btnPositive.setTextSize(31);

                Button btnNeuteral = alert.getButton(Dialog.BUTTON_NEUTRAL);
                btnNeuteral.setTextSize(31);
            }
        });

        alert.show();

        alert.getWindow().setBackgroundDrawableResource(R.drawable.loose);

        int textViewId = alert.getContext().getResources().getIdentifier("android:id/alertTitle", null, null);
        TextView tv = (TextView) alert.findViewById(textViewId);
        tv.setTextColor(getResources().getColor(R.color.allert_loose_color));
    }

    @SuppressLint("ResourceAsColor")
    private void showTrueAnswer() {
        switch (rightAnswer) {
            case 1:
                BtnVar1.setTextColor(ContextCompat.getColor(this, R.color.white_color));
                break;
            case 2:
                BtnVar2.setTextColor(ContextCompat.getColor(this, R.color.white_color));
                break;
            case 3:
                BtnVar3.setTextColor(ContextCompat.getColor(this, R.color.white_color));
                break;
            case 4:
                BtnVar4.setTextColor(ContextCompat.getColor(this, R.color.white_color));
                break;
            case 5:
                BtnVar5.setTextColor(ContextCompat.getColor(this, R.color.white_color));
                ;
                break;
            case 6:
                BtnVar6.setTextColor(ContextCompat.getColor(this, R.color.white_color));
                break;
            case 7:
                BtnVar7.setTextColor(ContextCompat.getColor(this, R.color.white_color));
                break;
            case 8:
                BtnVar8.setTextColor(ContextCompat.getColor(this, R.color.white_color));
                break;
            case 9:
                BtnVar9.setTextColor(ContextCompat.getColor(this, R.color.white_color));
                break;
            case 10:
                BtnVar10.setTextColor(ContextCompat.getColor(this, R.color.white_color));
                break;
        }
    }

    @SuppressLint("ResourceAsColor")
    private void resetButtonColor() {
        BtnVar1.setTextColor(ContextCompat.getColor(this, R.color.allert_color));
        BtnVar2.setTextColor(ContextCompat.getColor(this, R.color.allert_color));
        BtnVar3.setTextColor(ContextCompat.getColor(this, R.color.allert_color));
        BtnVar4.setTextColor(ContextCompat.getColor(this, R.color.allert_color));
        BtnVar5.setTextColor(ContextCompat.getColor(this, R.color.allert_color));
        BtnVar6.setTextColor(ContextCompat.getColor(this, R.color.allert_color));
        BtnVar7.setTextColor(ContextCompat.getColor(this, R.color.allert_color));
        BtnVar8.setTextColor(ContextCompat.getColor(this, R.color.allert_color));
        BtnVar9.setTextColor(ContextCompat.getColor(this, R.color.allert_color));
        BtnVar10.setTextColor(ContextCompat.getColor(this, R.color.allert_color));


    }


}