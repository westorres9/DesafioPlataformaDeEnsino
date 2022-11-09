package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Lesson;
import entities.Task;
import entities.Video;

public class Program {
	
	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		List<Lesson> list = new ArrayList<>();
		
		System.out.println("Quantas aulas tem o curso? ");
		int n = sc.nextInt();
		
		for (int i=0; i<n ; i++) {
			System.out.println("Dados da " + (i+1) + "a aula: ");
			System.out.println("Conteudo da tarefa (c/t)? ");
			char ch = sc.next().charAt(0);
			
			if (ch == 'c') {
				sc.nextLine();
				System.out.println("Título: ");
				String title = sc.nextLine();
				System.out.println("URL do vídeo: ");
				String url = sc.nextLine();
				System.out.println("Duração do vídeo: ");
				int seconds = sc.nextInt();
				
				list.add(new Video(url, seconds));
			
			}
			else {
				sc.nextLine();
				System.out.println("Título: ");
				String title = sc.nextLine();
				System.out.println("Description: ");
				String description = sc.nextLine();
				System.out.println("Quantidade de questões: ");
				int questionCount = sc.nextInt();
				
				list.add(new Task(description, questionCount));
			}
		}
		System.out.println();
		
		int sum = 0;
		
		System.out.println("DURAÇÃO TOTAL DO CURSO: ");
		for (Lesson lesson : list ) {
			int time = lesson.duration();
			sum += time;
		}
		
		System.out.println(sum);
		
		sc.close();
	}

}
