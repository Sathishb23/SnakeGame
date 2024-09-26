package Gamming;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class TicTacTio 
{
	int bordwidth=600;
	int bordheight=650;
	
	JFrame frame=new JFrame("Tic-Tac-Toe");
	JLabel jl=new JLabel();
	JPanel jp=new JPanel();
	JPanel jp1=new JPanel();
	JButton jb=new JButton();
	
	JButton [][]board=new JButton[3][3];
	String playerx="X";
	String playero="O";
	String currentplayer=playerx;
	boolean gameover=false;
	int trun=0;
	
	TicTacTio()
	{
		frame.setVisible(true);
		frame.setSize(bordwidth, bordheight);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());
		
		jl.setBackground(Color.darkGray);
		jl.setForeground(Color.gray);
		jl.setFont(new Font("Arial",Font.BOLD,50));
		jl.setHorizontalAlignment(jl.CENTER);
		jl.setText("Tic-Tac-Toe");
		frame.add(jl);
		
		jp.setLayout(new BorderLayout());
		jp.add(jl);
		frame.add(jp,BorderLayout.NORTH);
		
		jp1.setLayout(new GridLayout(3,3));
		jp1.setBackground(Color.darkGray);
		frame.add(jp1);
		
		for(int r=0;r<3;r++) 
		{
			for(int c=0;c<3;c++) 
			{
				JButton jb=new JButton();
				board[r][c]=jb;
				jp1.add(jb);
				
				jb.setBackground(Color.darkGray);
				jb.setForeground(Color.white);
				jb.setFont(new Font("Arial",Font.BOLD,120));
				jb.setFocusable(false);
				//jb.setText(currentplayer);
				
				jb.addActionListener(new ActionListener() 
				{

					
					public void actionPerformed(ActionEvent e)
					{
						if(gameover)return;
						JButton jb=(JButton) e.getSource();
						if(jb.getText()=="") 
						{
							jb.setText(currentplayer);
							trun++;
						
						cheackWinner();
						if(!gameover) 
						{
							currentplayer=currentplayer==playerx ? playero:playerx;
							jl.setText(currentplayer+"'S turn.");
						}
						}
					}
					
				});
			}
		}
		
	}

	protected void cheackWinner() 
	{
		for(int r=0;r<3;r++) 
		{
			if(board[r][0].getText()=="") 
			{
				continue;
			}
			if(board[r][0].getText()==board[r][1].getText() &&
					board[r][1].getText()==board[r][2].getText()) 
			{
				for(int i=0;i<3;i++) 
				{
					setWinner(board[r][i]);
				}
				gameover=true;
				return;
			}
		}
		for(int c=0;c<3;c++) 
		{
			if(board[0][c].getText()=="") 
			{
				continue;
			}
			if(board[0][c].getText()==board[1][c].getText() &&
					board[1][c].getText()==board[2][c].getText()) 
			{
				for(int i=0;i<3;i++) 
				{
					setWinner(board[i][c]);
				}
				gameover=true;
				return;
			}
		}
		if(board[0][0].getText()==board[1][1].getText() && 
				board[1][1].getText()==board[2][2].getText() &&
				board[0][0].getText()!="") 
		{
			for(int i=0;i<3;i++) 
			{
				setWinner(board[i][i]);
			}
			gameover=true;
			return;
		}
		if(board[0][2].getText()==board[1][1].getText() && 
				board[1][1].getText()==board[2][0].getText() &&
				board[0][2].getText()!="") 
		{
			setWinner(board[0][2]);
			setWinner(board[1][1]);
			setWinner(board[2][0]);
			gameover=true;
			return;
		}
		if(trun==9) 
		{
			for(int r=0;r<3;r++) 
			{
				for(int c=0;c<3;c++) 
				{
					
					setTie(board[r][c]);

				}
				
			}
			gameover=true;
		}
	}

	private void setTie(JButton jButton)
	{
		jButton.setForeground(Color.orange);
		jButton.setBackground(Color.gray);
		jl.setText("Tie!");
		
	}

	private void setWinner(JButton jButton) 
	{
		jButton.setForeground(Color.green);
		jButton.setBackground(Color.gray);
		jl.setText(currentplayer+"is the Winner");
		
	}
	
	
}
