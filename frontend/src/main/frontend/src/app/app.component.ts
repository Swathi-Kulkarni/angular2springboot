import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, FormBuilder, Validators } from '@angular/forms';

import { User } from './user.interface';
import { UserService } from './userservice.service';
import { ResponseData } from './response.interface';

@Component({
    moduleId: module.id,
    selector: 'my-app',
    templateUrl: 'app.component.html',
    providers:[UserService	]
})
export class AppComponent implements OnInit {
    public myForm: FormGroup; // our model driven form
    public submitted: boolean; // keep track on whether form is submitted
    public events: any[] = []; // use later to display form changes
    response:String;

    constructor(private _fb: FormBuilder,private _userService:UserService) { } // form builder simplify form initialization

    ngOnInit() {
        // we will initialize our form model here
            this.myForm = this._fb.group({
            name: ['', [<any>Validators.required, <any>Validators.minLength(5)]],
            age:['',[<any>Validators.required]],
            salary:['',[<any>Validators.required,<any>Validators.minLength(4)]],
        });
    }

    save(model: User, isValid: boolean) {
        this.submitted = true; // set form submit to true
        // check if model is valid
        // if valid, call API to save customer
        console.log(model, isValid);
	    this._userService.validateUser(model)
    .then(data => { this.response = data;
    console.log(this.response);
    console.log(data);
    } );
  }
}
