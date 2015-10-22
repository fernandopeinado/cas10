 class Identified {
    
    getId() {
        return this.id;
    }
    
    setId(id) {
        this.id = id;
    }
};

class Role extends Identified {
     constructor(geometry, materials) {
         super();
         this.id = null;
         this.name = null;
         this.group = null;
         this.description = null;
         this.help = null;
     }
     
     toString() {
         return this.description || this.name;
     }
};

class UserGroup extends Identified {
     constructor(geometry, materials) {
        super();
        this.id = null;
        this.name = null;
        this.parent = null;
        this.roles = [];
     }
     
     toString() {
         return this.name;
     }
};

class User extends Identified {
     constructor(geometry, materials) {
        super();
        this.id = null;
        this.login = null;
        this.name;
        this.email;
        this.password;
        this.groups = [];
     }
     
     toString() {
         return this.name;
     }
};


module.exports = { "Role": Role, "UserGroup": UserGroup, "User": User };