function uploadFile() {

  var file = document.getElementById("fileOb");
  var form = new FormData();
  form.append("image", file.files[0]);
  var inputs = {
    url: "https://imgbb.com/upload?key=772b95ad61308f4c9b9c7b31a3afad35",
    method: "POST",
    timeout: 0,
    processData: false,
    mimeType: "multipart/form-data",
    contentType: false,
    data: form,
  };

  $.ajax(inputs).done(function (response) {
    var job = JSON.parse(response);
    $("#imageUrl").val(job.data.url);
  });
}
