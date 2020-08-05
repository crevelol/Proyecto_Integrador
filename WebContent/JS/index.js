var resp2 = [];
function myfuntion() {
  var comunitys = document.getElementById("comunitys").value;
  var genere = document.getElementById("genere").value;
  var graph = document.getElementById("graph").value;
  
      const data = { id: comunitys, genere: genere };

  if (graph == "line") {
    // alert(graph);
    const rawResponse = async () => {
      await fetch("https://app-rest-pg-ts.herokuapp.com/communitys", {
        method: "POST",
        headers: {
          Accept: "application/json",
          "Content-Type": "application/json",
        },
        body: JSON.stringify(data),
      })
        .then((res) => res.json())
        .then((data) => {
          data.forEach((res) => {
            resp2.push([res.name, res.cantidad]);
          });
        });
      console.log(resp2);
      Highcharts.chart("container", {
        chart: {
          type: "column",
        },
        title: {
          text: "Nacimientos Datos por Comunidades Autónomas",
        },
        // subtitle: {
        // //     // text: 'Click the columns to view versions. Source: <a href="http://statcounter.com" target="_blank">statcounter.com</a>'
        // },
        accessibility: {
          announceNewData: {
            enabled: true,
          },
        },
        xAxis: {
          type: "category",
        },
        yAxis: {
          title: {
            text: "Total percent market share",
          },
        },
        legend: {
          enabled: false,
        },
        plotOptions: {
          series: {
            borderWidth: 0,
            dataLabels: {
              enabled: true,
              format: "{point.y}",
            },
          },
        },

        series: [
          {
            name: "Cantidad",
            colorByPoint: true,
            data: resp2,
          },
        ],
      });
      resp2 = [];
    };
    rawResponse();
  } else {
    if (graph == "pie") {
      const rawResponse = async () => {
        await fetch("https://app-rest-pg-ts.herokuapp.com/communitys", {
          method: "POST",
          headers: {
            Accept: "application/json",
            "Content-Type": "application/json",
          },
          body: JSON.stringify(data),
        })
          .then((res) => res.json())
          .then((data) => {
            data.forEach((res) => {
              resp2.push([res.name, res.cantidad]);
            });
          });

        console.log(resp2);
        Highcharts.chart("container", {
          chart: {
            plotBackgroundColor: null,
            plotBorderWidth: null,
            plotShadow: false,
            type: "pie",
          },
          title: {
            text: "Nacimientos Datos por Comunidades Autónomas, 2018",
          },
          tooltip: {
            pointFormat: "{series.resp2.name}: <b>{point.percentage:.1f}%</b>",
          },
          accessibility: {
            point: {
              valueSuffix: "%",
            },
          },
          plotOptions: {
            pie: {
              allowPointSelect: true,
              cursor: "pointer",
              dataLabels: {
                enabled: false,
              },
              showInLegend: true,
            },
          },
          series: [
            {
              colorByPoint: true,
              data: resp2,
            },
          ],
        });
        resp2 = [];
      };
      rawResponse();
    }
  }
}


function myfuntion2() {
  // var comunitys = document.getElementById("comunitys").value;
  var genere = document.getElementById("genere").value;
  var graph = document.getElementById("graph").value;
  
      // const data = { genere: genere };
      console.log(genere , graph)

  if (graph == "line") {
    // alert(graph);
    const rawResponse = async () => {
      await fetch(`https://app-rest-pg-ts.herokuapp.com/communitys/${genere}`
      )
      .then((res) => res.json())
      .then((data) => {
          data.forEach((res) => {
            resp2.push([res.name, res.cantidad]);
          });
        });
      console.log(resp2);
      Highcharts.chart("container", {
        chart: {
          type: "column",
        },
        title: {
          text: "Nacimientos Datos por Comunidades Autónomas",
        },
        // subtitle: {
        // //     // text: 'Click the columns to view versions. Source: <a href="http://statcounter.com" target="_blank">statcounter.com</a>'
        // },
        accessibility: {
          announceNewData: {
            enabled: true,
          },
        },
        xAxis: {
          type: "category",
        },
        yAxis: {
          title: {
            text: "Total percent market share",
          },
        },
        legend: {
          enabled: false,
        },
        plotOptions: {
          series: {
            borderWidth: 0,
            dataLabels: {
              enabled: true,
              format: "{point.y}",
            },
          },
        },

        series: [
          {
            name: "Cantidad",
            colorByPoint: true,
            data: resp2,
          },
        ],
      });
      resp2 = [];
    };
    rawResponse();
  } else {
    if (graph == "pie") {
      const rawResponse = async () => {
        await fetch(`https://app-rest-pg-ts.herokuapp.com/communitys/${genere}`)
          .then((res) => res.json())
          .then((data) => {
            data.forEach((res) => {
              resp2.push([res.name, res.cantidad]);
            });
          });

        console.log(resp2);
        Highcharts.chart("container", {
          chart: {
            plotBackgroundColor: null,
            plotBorderWidth: null,
            plotShadow: false,
            type: "pie",
          },
          title: {
            text: "Nacimientos Datos por Comunidades Autónomas, 2018",
          },
          tooltip: {
            pointFormat: "{series.resp2.name}: <b>{point.percentage:.1f}%</b>",
          },
          accessibility: {
            point: {
              valueSuffix: "%",
            },
          },
          plotOptions: {
            pie: {
              allowPointSelect: true,
              cursor: "pointer",
              dataLabels: {
                enabled: false,
              },
              showInLegend: true,
            },
          },
          series: [
            {
              colorByPoint: true,
              data: resp2,
            },
          ],
        });
        resp2 = [];
      };
      rawResponse();
    }
  }
}

function myfuntionClear(){
  resp2 = [];
}

fetch("https://app-rest-pg-ts.herokuapp.com/communitys")
  .then((res) => res.json())
  .then((data) => {
    // console.log(data);
    data.forEach((res) => {
      resp2.push([res.ciudad, res.cantidad]);
    });

    Highcharts.chart("container", {
      chart: {
        plotBackgroundColor: null,
        plotBorderWidth: null,
        plotShadow: false,
        type: "pie",
      },
      title: {
        text: "Nacimientos Datos por Comunidades Autónomas, 2018",
      },
      tooltip: {
        pointFormat: "{series.resp2.name}: <b>{point.percentage:.1f}%</b>",
      },
      accessibility: {
        point: {
          valueSuffix: "%",
        },
      },
      plotOptions: {
        pie: {
          allowPointSelect: true,
          cursor: "pointer",
          dataLabels: {
            enabled: false,
          },
          showInLegend: true,
        },
      },
      series: [
        {
          colorByPoint: true,
          data: resp2,
        },
      ],
    });
    resp2 = [];
  });