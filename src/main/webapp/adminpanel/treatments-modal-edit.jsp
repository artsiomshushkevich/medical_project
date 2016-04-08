<div class="modal treatments_edit_modal fade" tabindex="-1" role="dialog">
    <div class="modal-dialog">
        <div class="modal-content">.

            <form method="post" action="/update.action">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title">Update treatment info</h4>
                </div>
                <div class="modal-body">
                    <div class="form-group">
                        <input id="treatments_edit_id" name="treatment.id" type="hidden">
                        <div class="form-group">
                            <label>Prescription: <input type="text" class="form-control" name="treatment.prescription"></label>
                        </div>
                        <div class="form-group">
                            <label>Cure count: <input type="text" class="form-control" name="treatment.cureCount"></label>
                        </div>
                        <div class="form-group">
                            <label>Method of using: <input type="text" class="form-control" name="treatment.methodOfUsing"></label>
                        </div>
                        <div class="form-group">
                            <label>Cure id: <input type="text" class="form-control" name="treatment.cureId"></label>
                        </div>
                        <div class="form-group">
                            <label>Visit id: <input type="text" class="form-control" name="treatment.visitId"></label>
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
