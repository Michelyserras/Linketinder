import { DataService } from '../services/DataService';


declare const Chart: any;

export function gerarGraficoCompetencias(): string {
    DataService.carregarDados();
    const contagem = DataService.contarCompetenciasCandidatos();


    if (Object.keys(contagem).length === 0) {
        return `
            <div class="grafico-container">
                <h3>Competências dos Candidatos</h3>
                <div class="grafico-vazio">
                    <p>Nenhum candidato cadastrado ainda.</p>
                </div>
            </div>
        `;
    }

    const canvasId = `competenciasChart_${Date.now()}`;


    const html = `
        <div class="grafico-container">
            <h3>Competências dos Candidatos</h3>
            <div class="chart-wrapper">
                <canvas id="${canvasId}" width="400" height="200"></canvas>
            </div>
        </div>
    `;


    setTimeout(() => {
        criarGrafico(canvasId, contagem);
    }, 100);

    return html;
}

function criarGrafico(canvasId: string, contagem: { [competencia: string]: number }): void {
    const canvas = document.getElementById(canvasId) as HTMLCanvasElement;
    if (!canvas) return;
    
    
    const todasCompetencias: [string, number][] = [];

    for (const competencia in contagem) {
        const nomeCompetencia = competencia;
        const quantidadeCandidatos = contagem[competencia];
        todasCompetencias.push([nomeCompetencia, quantidadeCandidatos]);
    }

    todasCompetencias.sort((a, b) => b[1] - a[1]);

    const competenciasOrdenadas = todasCompetencias.slice(0, 10);

    const labels = competenciasOrdenadas.map(([competencia]) => competencia);
    const dados = competenciasOrdenadas.map(([, quantidade]) => quantidade);

    new Chart(canvas, {
        type: 'bar',
        data: {
            labels: labels,
            datasets: [{
                label: 'Quantidade de Candidatos',
                data: dados,
                backgroundColor: '#5f9ea0',
                borderColor: '#4a7c7e',
                borderWidth: 1
            }]
        },
        options: {
            responsive: true,
            maintainAspectRatio: false,
            plugins: {
                legend: {
                    display: false
                }
            },
            scales: {
                y: {
                    beginAtZero: true,
                    ticks: {
                        stepSize: 1
                    }
                }
            }
        }
    });
}
