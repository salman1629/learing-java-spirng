import React, { useEffect } from "react";
import { pieData } from "../data";
import * as d3 from "d3";

function PieChart() {
  const dimensions = {
    width: 500,
    height: 500,
    top: 20,
    bottom: 20,
    left: 20,
  };
  const radius = dimensions.width / 2;
  function drawGraphs() {
    const arc = d3
      .arc()
      .innerRadius(radius * 0.4)
      .outerRadius(radius);

    const pie = d3.pie().value((d) => d.value);

    const colors = d3.scaleOrdinal(d3.schemeCategory10);

    const svg = d3
      .select("svg")
      .attr("width", dimensions.width + dimensions.left)
      .attr("height", dimensions.height + dimensions.top)
      .append("g")
      .attr(
        "transform",
        `translate(${dimensions.width / 2 + dimensions.left},${
          dimensions.height / 2 + dimensions.top
        })`
      );

    const arcs = svg.selectAll("arc").data(pie(pieData)).enter().append("g");

    arcs
      .append("path")
      .attr("d", arc)
      .attr("fill", (d, i) => colors(i));

    arcs
      .append("text")
      .text((d) => d.data.name)
      .attr("fill", "white")
      .attr("text-anchor", "middle")
      .attr("transform", (d, i) => {
        const [x, y] = arc.centroid(d);
        return `translate(${x * 1.1},${y * 1.1})`;
      });
  }
  useEffect(() => {
    drawGraphs();
  }, []);
  return <div className="flex-1/2" >
    <svg></svg>
  </div>;
}

export default PieChart;
