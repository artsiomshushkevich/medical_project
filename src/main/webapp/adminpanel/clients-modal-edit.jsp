<div class="modal clients_edit_modal fade" tabindex="-1" role="dialog">
    <div class="modal-dialog">
        <div class="modal-content">.

            <form method="post" action="clients-update.action">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title">Update client info</h4>
                </div>
                <div class="modal-body">
                    <div class="form-group">
                        <input id="clients_edit_id" name="client.id" type="hidden">
                        <input id="clients_edit_userId" name="client.userId" type="hidden">
                        <div class="form-group">
                            <label>First name: <input id="clients_edit_firstname" type="text" required  class="form-control" name="client.firstname"></label>
                        </div>
                        <div class="form-group">
                            <label>Second name: <input id="clients_edit_secondname" type="text" required class="form-control" name="client.secondname"></label>
                        </div>
                        <div class="form-group">
                            <label>Last name: <input id="clients_edit_lastname" type="text" required class="form-control" name="client.lastname"></label>
                        </div>
                        <div class="form-group">
                            <label>Phone number: <input id="clients_edit_phoneNumber" type="text" required class="form-control" name="client.phoneNumber"></label>
                        </div>
                        <div class="form-group">
                            <label>Address: <input id="clients_edit_address" type="text" required class="form-control" name="client.address"></label>
                        </div>
                        <div class="form-group">
                            <label>Email: <input id="clients_edit_email" type="text" required class="form-control" name="client.email"></label>
                        </div>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                        <button type="submit" class="btn btn-primary add-btn">Save changes</button>
                    </div>
                </div>
            </form>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div><!-- /.modal -->
