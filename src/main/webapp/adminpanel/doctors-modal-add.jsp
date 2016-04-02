<div class="modal doctors_add_modal fade" tabindex="-1" role="dialog">
    <div class="modal-dialog">
        <div class="modal-content">.

            <form method="post" action="doctors-add.action">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title">Add new doctors</h4>
                </div>
                <div class="modal-body">
                    <div class="form-group">
                        <div class="form-group">
                            <label>User id: <input type="number" class="form-control" name="doctor.userId"></label>
                        </div>
                        <div class="form-group">
                            <label>First name: <input type="text" class="form-control" name="doctor.firstname"></label>
                        </div>
                        <div class="form-group">
                            <label>Second name: <input type="text" class="form-control" name="doctor.secondname"></label>
                        </div>
                        <div class="form-group">
                            <label>Last name: <input type="text" class="form-control" name="doctor.lastname"></label>
                        </div>
                        <div class="form-group">
                            <label>Qualification: <input type="text" class="form-control" name="doctor.qualification"></label>
                        </div>
                        <div class="form-group">
                            <label>Speciality: <input type="text" class="form-control" name="doctor.speciality"></label>
                        </div>
                        <div class="form-group">
                            <label>Phone number: <input type="text" class="form-control" name="doctor.phoneNumber"></label>
                        </div>
                        <div class="form-group">
                            <label>Email: <input type="text" class="form-control" name="doctor.email"></label>
                        </div>
                        <div class="form-group">
                            <label>Department id: <input type="number" class="form-control" name="doctor.departmentId"></label>
                        </div>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                        <button type="submit" class="btn btn-primary add-btn">Save</button>
                    </div>
                </div>
            </form>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div><!-- /.modal -->
