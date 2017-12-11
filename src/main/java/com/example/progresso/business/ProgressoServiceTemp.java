package com.example.progresso.business;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Function;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ProgressoServiceTemp {
	
	private List<Progresso> progressos = new ArrayList<Progresso>();
	
	private Map<Status, Status> mapTransicoes = new HashMap<>();
	
	@PostConstruct
	public void init() {
		mapTransicoes.put(Status.BUFFER, Status.COORDENADOR);
		mapTransicoes.put(Status.COORDENADOR, Status.FILA);
		mapTransicoes.put(Status.FILA, Status.EXECUTANDO);
		mapTransicoes.put(Status.EXECUTANDO, Status.FINALIZANDO);
		mapTransicoes.put(Status.FINALIZANDO, Status.MORRER);
	}
	
	@Scheduled(initialDelay=0, fixedRate=5000)
	public void geraProgressosAleatorios() {
		
		final ThreadLocalRandom x = ThreadLocalRandom.current();
		
		progressos.forEach(p -> {
			
			Integer hit = x.nextInt(60);
			
			p.setHp( p.getHp() - hit );
			
			// Se morrer faz a transição
			if (p.getHp() <= 0) {
				
				Status statusAtual = p.getStatusAtual();
				Status proximoStatus = mapTransicoes.get(statusAtual);
				
				p.setHp(100);
				p.setStatusAtual(proximoStatus);
			}
		});
		
		List<Progresso> novalista = progressos.stream().filter(p -> !p.getStatusAtual().equals(Status.MORRER)).collect(Collectors.toList());
		
		this.progressos = novalista;
	}
	

	public List<ReporteStatus> getReporte(){
		
		Map<Status, Long> collect = progressos.stream().map(p -> p.getStatusAtual()).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		
		List<ReporteStatus> result = collect.entrySet()
			.stream()
			.map(entry -> new ReporteStatus(entry.getKey(), entry.getValue()))
			.collect(Collectors.toList());
		
		return result;
	}
	
	public void addProgresso() {
		
		final ThreadLocalRandom x = ThreadLocalRandom.current();

		progressos.add(new Progresso(x.nextInt()));
	}
}
