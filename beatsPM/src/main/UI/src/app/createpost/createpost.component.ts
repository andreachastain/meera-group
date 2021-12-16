import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, FormControl } from '@angular/forms';
import { postCreationObject } from './postCreationObject';

@Component({
  selector: 'app-createpost',
  templateUrl: './createpost.component.html',
  styleUrls: ['./createpost.component.css']
})
export class CreatepostComponent implements OnInit {
  

  createPostForm = new FormGroup({
    postBody: new FormControl(''),
    postTitle: new FormControl(''),
    genre: new FormControl(),
  });

  constructor(
    private fb: FormBuilder,
  ) {
    };

  ngOnInit(): void {
    this.initializeForm();
  };

  initializeForm(): void {
    this.createPostForm = this.fb.group({
      postTitle: '',
      postBody: '',
      genre: '',
      });
    };

    get f() {
      return this.createPostForm.controls;
    };

  onSubmit(): void {
    console.log(this.createPostForm);

    let postCreation = JSON.stringify(this.createPostForm.value);
    alert(postCreation);
  };
}
