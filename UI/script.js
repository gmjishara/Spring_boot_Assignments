let tableBody = document.querySelector("#table-body");
let modelGrid1 = document.querySelector(".modal-grid1");
let modelGrid2 = document.querySelector(".modal-grid2");
let count = 0;
let tableRow = `<undefined>`;
let results;

const onClickFunction = (id) => {
  results.map((item) => {
    if (item.indexNumber == id) {
      let content = `<p><span>Index No: </span>${item.indexNumber}</p>
         <p><span>First Name: </span>${item.firstName}</p>
         <p><span>Last Name: </span>${item.lastName}</p>
         <p><span>Age: </span>${item.age}</p>
         <p><span>Gender: </span>${item.gender}</p>
         <p><span>Address: </span>${item.address}</p>
         <p><span>Email: </span>${item.email}</p>
         <p><span>Phone Number: </span>${item.phoneNumber}</p>
         <p><span>University: </span>${item.university}</p>
         <p><span>Institute: </span>${item.institute}</p>
         <p><span>Batch: </span>${item.batch}</p>`;
      modelGrid2.innerHTML = content;

      let photo = `<img src="http://localhost:8080/images/${item.image}" class="photo"></img>`;
      modelGrid1.innerHTML = photo;
    }
  });
};

const studentRegister = () => {

  const formData=new FormData();
  
  formData.append("indexNumber",document.getElementById("indexNumber").value);
  formData.append("firstName",document.getElementById("firstName").value);
  formData.append("lastName",document.getElementById("lastName").value);
  formData.append("age",document.getElementById("age").value)
  formData.append("gender",document.getElementById("gender").value);
  formData.append("address",document.getElementById("address").value);
  formData.append("email",document.getElementById("email").value);
  formData.append("phonenNumber",document.getElementById("phoneNumber"));
  formData.append("university",document.getElementById("university").value);
  formData.append("institute",document.getElementById("institute").value);
  formData.append("batch",document.getElementById("batch").value);
  formData.append("image",document.getElementById("image").files[0]);

  const requestOptions = {
    method: "POST",
    body: formData,
  };

  //register students
  fetch("http://localhost:8080/student", requestOptions)
    .then((response) => response.json())
    .then((data) => {
      if (data) {
        Swal.fire({
          position: "center",
          icon: "success",
          title: "Your work has been saved",
          showConfirmButton: false,
          timer: 1500,
        });

        setTimeout(() => {
          window.location.reload();
        }, 1600);
      }
    })
    .catch((error) => console.log(error));
};

//form submit
form.addEventListener('submit',function(event){
  event.preventDefault();
  studentRegister();
})

//get students
fetch("http://localhost:8080/student")
  .then((response) => response.json())
  .then((result) => {
    results = result;
    result.map((item) => {
      let rows = `<tr class="rows">
           <th>${++count}</th>
           <td>${item.indexNumber}</td>
           <td>${item.firstName}</td>
           <td>${item.lastName}</td>
           <td>${item.address}</td>
           <td><button id="infoBtn" class="btn btn-info" data-student-id="${
             item.indexNumber
           }" data-bs-toggle="modal" data-bs-target="#studentDetailsModal">More</button></td>
        </tr>`;

      tableRow = tableRow + rows;
    });
    tableBody.innerHTML = tableRow;

    let buttonClick = document.querySelectorAll(".btn");

    buttonClick.forEach((button) => {
      button.addEventListener("click", (event) => {
        const objectId = event.target.getAttribute("data-student-id");
        onClickFunction(objectId);
      });
    });
  })
  .catch((error) => console.log(error));
