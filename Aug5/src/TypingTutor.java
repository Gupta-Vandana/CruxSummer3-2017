import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.Timer;

public class TypingTutor extends JFrame implements ActionListener {

	private JLabel lblTimer;
	private JLabel lblScore;
	private JLabel lblWord;
	private JTextField txtWord;
	private JButton btnStart;
	private JButton btnStop;
	private Timer timer = null;
	private boolean running = false;
	private int timeRemaining = 0;
	private int score = 0;
	String[] words = null;

	public TypingTutor(String[] words) {
		this.words = words;
		
		GridLayout layout = new GridLayout(3, 2);
		super.setLayout(layout);
		Font font = new Font("Classmate", 1, 90);

		lblTimer = new JLabel("Time");
		lblTimer.setFont(font);
		super.add(lblTimer);

		lblScore = new JLabel("Score:");
		lblScore.setFont(font);
		super.add(lblScore);

		lblWord = new JLabel("");
		lblWord.setFont(font);
		super.add(lblWord);

		txtWord = new JTextField("");
		txtWord.setFont(font);
		super.add(txtWord);

		btnStart = new JButton("Start");
		btnStart.setFont(font);
		btnStart.addActionListener(this);
		super.add(btnStart);

		btnStop = new JButton("Stop");
		btnStop.setFont(font);
		btnStop.addActionListener(this);
		super.add(btnStop);

		super.setExtendedState(MAXIMIZED_BOTH);
		super.setTitle("Typing Tutor");
		super.setVisible(true);
		super.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

		//?
		SetUpGame();
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == btnStart) {
			handleStart();
		} else if (e.getSource() == btnStop) {
			handleStop();
		} else if (e.getSource() == timer) {
			handleTimer();
		}

	}

	private void handleTimer() {
		// TODO Auto-generated method stub
		timeRemaining--;
		// timer.start();
		// running = true;

		int ridx = (int) (Math.random() * words.length);
		String actualWord = lblWord.getText();
		String expectedWord = txtWord.getText();

		// btnStart.setText("Pause");
		// txtWord.setEnabled(true);
		// btnStop.setEnabled(true);
		//
		// timer.stop();
		// running = false;

		//
		// btnStart.setText("Resume");
		// txtWord.setEnabled(false);
		// btnStop.setEnabled(false);
		//
		if (expectedWord.equals(actualWord)) {
			score++;
		}
		
		lblWord.setText(words[ridx]);
		txtWord.setText("");
		
		lblTimer.setText("Time" + ":" + timeRemaining);
		lblScore.setText("Score " + score);
		
		if (timeRemaining == 0) {
			handleStop();
		}
	}

	private void handleStop() {
		// TODO Auto-generated method stub
		//System.out.println("bye");
		timer.stop();
		int choice=JOptionPane.showConfirmDialog(this, "WANNA PLAY AGAIN ?");
		if (choice==JOptionPane.YES_OPTION){
			SetUpGame();
		}
		else if (choice==JOptionPane.NO_OPTION){
			super.dispose();
		}
		else if (choice==JOptionPane.CANCEL_OPTION){
			if (timeRemaining==0){
				SetUpGame();
			}
			else {
				timer.start();
			}
				
		}
		
	}

	private void SetUpGame() {
		timer = new Timer(5000, this);
		running = false;
		timeRemaining = 20;
		score = 0;
		lblTimer.setText("Time" + ":" + timeRemaining);
		lblScore.setText("Score " + score);
		lblWord.setText("");
		txtWord.setText("");
		txtWord.setEnabled(false);

		btnStart.setText("start");
		btnStart.setEnabled(true);

		btnStop.setText("stop");
		btnStop.setEnabled(true);

	}

	private void handleStart() {
		if (running == false) {
			timer.start();
			running = true;

			btnStart.setText("Pause");
			txtWord.setEnabled(true);
			btnStop.setEnabled(true);
		} else {
			timer.stop();
			running = false;

			btnStart.setText("Resume");
			txtWord.setEnabled(false);
			btnStop.setEnabled(false);
		}
	}

}
