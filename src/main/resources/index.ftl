<!DOCTYPE html>
<head>
<title>${ job }</title>
<link rel="stylesheet" href="/css/styles.css">
</head>
<body>
  <h1><span id="job-name">${ job }</span></h1>
  <div class="mermaid">
     graph TD
     ${ graph }
  </div>

  <script src="https://cdn.jsdelivr.net/npm/mermaid/dist/mermaid.min.js"></script>
  <script>mermaid.initialize({startOnLoad:true});</script>

</body>
